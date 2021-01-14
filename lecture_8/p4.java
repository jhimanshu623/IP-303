
public class p4 {
    public static int maxA(int n) {
        if(n<=3)
            return n;
        int strg[]=new int[n+1];
        strg[1]=1;
        strg[2]=2;
        strg[3]=3;
        for(int i=4;i<=n;i++)
        {
            strg[i]=i;
            for(int j=3;j<i;j++)
            {
                strg[i]=Math.max(strg[i],strg[i-j]*(j-1));
            }
        }
        return strg[n];
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(maxA(n));
    }
}