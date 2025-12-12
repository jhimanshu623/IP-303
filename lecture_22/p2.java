public class p2 {
    // tle
    public static int consecutiveNumbersSum(int n) {
        int ans=1;
        int sum=0;
        int i=1;
        int j=1;
        while(j<=n/2+1)
        {
            if(sum==n)
            {
                ans++;
                sum-=i;
                i++;
            }
            else if(sum<n)
            {
                sum+=j;
                j++;
            }
            else
            {
                sum-=i;
                i++;
            }
        }
        return ans;
    }

    public static int consecutiveNumbersSum2(int n) {
        int ans=0;
        for(int k=1;k*k<=2*n;k++)   // k can be run upto (k*k<2*n)
        {
            if((n-(k*(k-1)/2)) % k ==0)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n=18;
        System.out.println(consecutiveNumbersSum(n));
        System.out.println(consecutiveNumbersSum2(n));
    }    
}