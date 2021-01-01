/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int catalan(int n)
    {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int l=0;
            int r=i-1;
            while(l<i)
            {
                dp[i]+=dp[l]*dp[r];
                l++;r--;
            }
        }
        return dp[n];
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    System.out.println(catalan(n));
		}
	}
}