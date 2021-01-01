import java.util.Scanner;

public class p1
{
    // public static int solve(int n)
    // {
    //     if(n<=1)
    //         return 0;
    //     else if(n==2)
    //         return 3;
    //     int nm2=solve(n-2);
    //     return nm2+nm2*2;
    // }
    public static long solve(int n)
    {
        long[][] dp=new long[8][n];
        dp[0][0]=1;
        dp[3][0]=1;
        dp[6][0]=1;
        for(int i=1;i<n;i++)
        {
            dp[0][i]+=dp[7][i-1];
            dp[1][i]+=dp[6][i-1];
            dp[2][i]+=dp[5][i-1];
            dp[3][i]+=dp[7][i-1];
            dp[3][i]+=dp[4][i-1];
            dp[4][i]+=dp[3][i-1];
            dp[5][i]+=dp[2][i-1];
            
            dp[6][i]+=dp[7][i-1];
            dp[6][i]+=dp[1][i-1];
            dp[7][i]+=dp[0][i-1];
            dp[7][i]+=dp[3][i-1];
            dp[7][i]+=dp[6][i-1];
        }
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[7][n-1];
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            int n=sc.nextInt();
            if(n==-1)
                break;
            System.out.println(solve(n));
        }
    }
}