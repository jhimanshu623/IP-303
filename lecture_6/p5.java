import java.util.*;

public class p5 {
    public static int[] solvet(int lt,int rt,int lf,int rf,char ch)
    {
        int ct=0;
        int cf=0;
        if(ch=='|')
        {
            ct=lt*rt+lt*rf+lf*rt;
            cf=lf*rf;
        }
        else if(ch=='&')
        {
            ct=lt*rt;
            cf=lf*rf+lf*rt+lt*rf;
        }
        else
        {
            ct=lt*rf+lf*rt;
            cf=lt*rt+lf*rf;
        }
        int ans[]=new int[2];
        ans[0]=ct;
        ans[1]=cf;
        return ans;
    }
    public static int booleanParanthesis(ArrayList<Boolean> barr,ArrayList<Character> carr)
    {
        int n=barr.size();
        int ldp[][]=new int[n][n];
        int rdp[][]=new int[n][n];
        for(int g=0;g<n;g++)
        {
            for(int i=0;i<n-g;i++)
            {
                int j=i+g;
                if(g==0)
                {
                    ldp[i][j]=(barr.get(i)==true)?1:0;
                    rdp[i][j]=(barr.get(i)==false)?1:0;
                }
                else
                {
                    for(int k=0;k<g;k++)
                    {
                        int lt=ldp[i][i+k];
                        int rt=ldp[i+1+k][j];
                        int lf=rdp[i][i+k];
                        int rf=rdp[i+1+k][j];
                        int ans[]=solvet(lt,rt,lf,rf,carr.get(i+k));
                        ldp[i][j]+=ans[0];
                        rdp[i][j]+=ans[1];
                    }
                }
            }
        }
        return ldp[0][n-1]; 
    }
    public static void main (String[] args) {
        String s="T^F|F";
        ArrayList<Boolean> barr=new ArrayList<>();
        ArrayList<Character> carr=new ArrayList<>();
        for(char ch:s.toCharArray())
        {
            if(ch=='T')
                barr.add(true);
            else if(ch=='F')
                barr.add(false);
            else 
                carr.add(ch);
        }
        System.out.println(booleanParanthesis(barr,carr));
	}
}