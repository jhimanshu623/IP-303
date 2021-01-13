
public class p4 {
    public static int count01(int n)
    {
        if(n==0)
            return 0;
        int o=1;
        int z=1;
        int mod=1000000007;
        for(int i=2;i<=n;i++)
        {
            int no=z;
            int nz=(o+z)%mod;
            o=no;
            z=nz;
        }
        return (o+z)%mod;
    }
    public static void main(String args[])
    {
        int n=100;
        System.out.println(count01(n));
    }
}