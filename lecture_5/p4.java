public class p4 {

    public static int friendsPair(int n)
    {
        int strg[]=new int[n+1];
        strg[0]=1;
        strg[1]=1;
        for(int i=2;i<=n;i++)
        {
            strg[i]=strg[i-1]+(i-1)*strg[i-2];
        }
        return strg[n];
    }

    // for large input
    // n=84
    public static long friendsPair_02(int n)
    {
        long strg[]=new long[n+1];
        strg[0]=1;
        strg[1]=1;
        int mod=(int)(Math.pow(10,9))+7;
        for(int i=2;i<=n;i++)
        {
            strg[i]=(strg[i-1]+((i-1)*strg[i-2])%mod)%mod;
        }
        
        return strg[n];
    }
    public static void main(String args[])
    {
        int n=3;
        System.out.println(friendsPair(n));
    }
}