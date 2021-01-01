public class p2 {
    // 25 ms
    public int minSteps(int n) {
        int strg[]=new int[n+1];
        strg[0]=0;
        strg[1]=0;
        for(int i=2;i<strg.length;i++)
        {
            for(int j=i-1;j>=1;j--)
            {
                if(i%j==0)
                {
                    strg[i]=strg[j]+(i/j);
                    break;
                }
            }
        }
        return strg[n];
    }

    // prime factorization using seive 
    // 1ms
    public int minSteps1(int n)
    {
        boolean arr[]=new boolean[n+1];
        int res[]=new int[n+1];
        Arrays.fill(arr,true);
        for(int i=0;i<=n;i++)
            res[i]=i;
        arr[0]=false;
        arr[1]=false;
        for(int i=2;i*i<=n;i++)
        {
            if(arr[i]==true)
            {
                for(int j=2;j*i<=n;j++)
                {
                    if(arr[j*i]==true)
                    {
                        arr[j*i]=false;
                        res[j*i]=i;
                    }
                }
            }
        }
        int j=n;
        int ans=0;
        while(j>1)
        {
            ans+=res[j];
            j=j/res[j];
        }
        return ans;
    }
    // prime factorization using seive
    // if res[i]==0 means i is a prime number
    public int minSteps4(int n)
    {
        int res[]=new int[n+1];
        for(int i=2;i*i<=n;i++)
        {
            if(res[i]==0)
            {
                for(int j=2;j*i<=n;j++)
                {
                    if(res[j*i]==0)
                    {
                        res[j*i]=i;
                    }
                }
            }
        }
        int j=n;
        int ans=0;
        while(j>1)
        {
            if(res[j]==0)
            {
                ans+=j;
                return ans;
            }
            ans+=res[j];
            j=j/res[j];
        }
        return ans;
    }

    // prime factorization 
    // 0 ms
    public int minSteps3(int n)
    {
        int ans=0;
        int x=2;
        while(n>1)
        {
            if(n%x==0)
            {
                ans+=x;
                n=n/x;
            }
            else
                x++;
        }
        return ans;
    }
}