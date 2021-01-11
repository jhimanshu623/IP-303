class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n,int[] primes) {
        long[] arr=new int[n];
        int[] p=new int[primes.length];
        arr[0]=(long)1;
        
        for(int i=1;i<n;i++)
        {
            long min=Long.MAX_VALUE;
            for(int j=0;j<primes.length;j++)
            {
                min=Math.min(min,primes[j]*arr[p[j]]);
            }
            for(int j=0;j<primes.length;j++)
            {
                if(primes[j]*arr[p[j]]==min)
                    p[j]++;
            }
            arr[i]=min;
        }
        return arr[n-1];
    }
}