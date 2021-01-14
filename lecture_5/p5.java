public class p5 {

    public static int kSubsets(int n,int k)
    {
        if(n==0 || k==0 || k>n)
            return 0;
        else if(n==1 || k==1)
            return 1;
        int count=0;
        count=(n-1)*kSubsets(n-1,k);
        count+=kSubsets(n-1,k-1);
        return count;
    }

    public static void main(String args[])
    {
        int n=3;
        int k=2;
        System.out.println(kSubsets(n,k));
    }
}