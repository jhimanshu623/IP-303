
import java.util.*;

public class p6 {
    public static int[] solvet(int maxl,int maxr,int minl,int minr,char ch)
    {
        int max=0;
        int min=0;
        if(ch=='+')
        {
            max=maxl+maxr;
            min=minl+minr;
        }
        else
        {
            max=maxl*maxr;
            min=minl*minr;
        }
        int ans[]=new int[2];
        ans[0]=max;
        ans[1]=min;
        return ans;
    }
    public static void maxdpMinExp(ArrayList<Integer> narr,ArrayList<Character> carr)
    {
        int n=narr.size();
        int maxdp[][]=new int[n][n];
        int mindp[][]=new int[n][n];
        for(int g=0;g<n;g++)
        {
            for(int i=0;i<n-g;i++)
            {
                int j=i+g;
                if(g==0)
                {
                    maxdp[i][j]=narr.get(i);
                    mindp[i][j]=narr.get(i);
                }
                else
                {
                    int max=Integer.MIN_VALUE;
                    int min=Integer.MAX_VALUE;
                    for(int k=0;k<g;k++)
                    {
                        int lt=maxdp[i][i+k];
                        int rt=maxdp[i+1+k][j];
                        int lf=mindp[i][i+k];
                        int rf=mindp[i+1+k][j];
                        int ans[]=solvet(lt,rt,lf,rf,carr.get(i+k));
                        max=Math.max(max,ans[0]);
                        min=Math.min(min,ans[1]);
                    }
                    maxdp[i][j]=max;
                    mindp[i][j]=min;
                }
            }
        }
        System.out.println(maxdp[0][n-1]);
        System.out.println(mindp[0][n-1]); 
    }
    public static void main (String[] args) {
        String s="1+2*3+4*5";
        ArrayList<Integer> narr=new ArrayList<>();
        ArrayList<Character> carr=new ArrayList<>();
        for(char ch:s.toCharArray())
        {
            if(ch=='+' || ch=='*')
                carr.add(ch);
            else 
                narr.add((int)(ch-'0'));
        }
        maxdpMinExp(narr,carr);
	}
}