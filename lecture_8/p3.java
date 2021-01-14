import java.util.Arrays;
public class p3 {
    // 25 ms
    public static int minSteps(int n) {
        int strg[]=new int[n+1];
        strg[0]=0;
        strg[1]=0;
        for(int i=2;i<strg.length;i++)
        {
            int j=i-1;
            while(j>=1)
            {
                if(i%j==0)
                {
                    strg[i]=strg[j]+(i/j);
                    break;
                }
                j--;
            }
        }
        return strg[n];
    }
    // 1ms
    public static int minSteps_02(int n)
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
    // 0ms
    public static int minSteps_03(int n)
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
    public static void main(String[] args) {
        int n=27;
        System.out.println(minSteps(n));
        System.out.println(minSteps_02(n));
    }
}