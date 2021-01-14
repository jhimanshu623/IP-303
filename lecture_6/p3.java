// https://www.geeksforgeeks.org/highway-billboard-problem/

public class p3 {
    
    public static int highwayBillboard(int m,int[] x,int[] revenue,int t)
    {
        int strg[]=new int[x[x.length-1]+1];
        int xi=x.length-1;
        strg[strg.length-1]=revenue[xi];
        xi--;
        for(int i=strg.length-2;i>=0;i--)
        {
            if(i==x[xi])
            {
                int nc=0;
                if((i+t+1) < strg.length)
                    nc=strg[i+t+1];
                strg[i]=Math.max(strg[i+1],revenue[xi]+nc);
                if(i==x[0])
                    return strg[i];
                xi--;
            }   
            else
            {
                strg[i]=strg[i+1];
            }         
        }
        return strg[x[0]];
    }
    public static void main(String args[])
    {
        int m=15;
        int x[]={6, 9, 12, 14};
        int revenue[] = {5, 6,  3,  7};
        int t = 2;
        System.out.println(highwayBillboard(m,x,revenue,t));
    }
}