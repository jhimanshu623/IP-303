/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    // O((n^2)k)
    // n floor,k eggs
    public static void eggDrop(int n,int k)
    {
        int[][] dp=new int[n+1][k+1];
        for(int f=0;f<=n;f++)
        {
            for(int e=0;e<=k;e++)
            {
                if(f==0 || e==0)
                    dp[f][e]=0;
                else if(f==1)
                    dp[f][e]=1;
                else if(e==1)
                    dp[f][e]=f;
                else
                { 
                    if(e>f)   //optimization 
                        dp[f][e]=dp[f][e-1];
                    else
                    {
                        int ans=n;
                        for(int s=1;s<=f;s++)
                        {
                            int eb=dp[s-1][e-1];
                            int es=dp[f-s][e];
                            int tans=Math.max(eb,es)+1;
                            ans=Math.min(ans,tans);
                        }
                        dp[f][e]=ans;
                    }
                }
            }
        }
        System.out.println(dp[n][k]);
    }
    
    // O(nk)
    public static void eggDropOptimal(int n,int k)
    {
        int[][] dp=new int[n+1][k+1];
        for(int t=1;t<=n;t++)
        {
            for(int e=1;e<=k;e++)
            {
                dp[t][e]=dp[t-1][e-1]+dp[t-1][e]+1;
            }
            if(dp[t][k]>=n){
                System.out.println(t);
                return;
            }
        }
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();  //eggs
		    int k=sc.nextInt();  //floors
		    eggDrop(k,n);
		}
	}
}