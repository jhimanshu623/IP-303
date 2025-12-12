// not worked


/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Pair
    {
        int x;
        int y;
        int g;
        Pair(int x,int y,int g)
        {
            this.x=x;
            this.y=y;
            this.g=g;
        }
    }
    public static Pair extendedEucledian(int a,int b)
    {
        if(b==0)
            return new Pair(1,0,1);
        Pair p=extendedEucledian(b,a%b);
        int x=p.y;
        int y=p.x - (a/b)*p.y;
        return new Pair(x,y,p.g);
    }
    public static int getComb(int n,int r)
    {
        if(n==0 || r==0 || r==n)
            return 1;
        int m=1000000007;
        int ncr=1;
        int ncrp1;
        for(int i=0;i<r;i++)
        {
            int a=((ncr % (m-1)) * ((n-i) % (m-1))) % (m-1);
            int b=i+1;
            int b1=(extendedEucledian(b,m-1).x) % (m-1);
            ncrp1=(a * b1) % (m-1);
            ncr=ncrp1;
        }
        // for(int i=0;i<r;i++)
        // {
        //     int a=ncr*(n-i);
        //     int b=i+1;
        //     ncrp1=(a/b);
        //     ncr=ncrp1;
        // }
        return ncr;
    }
    public static int solve(int n,int k)
    {
        int m=1000000007;
        int c=getComb(n-1,k-1);
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            int l=getComb(n-i,k-1);
            int s=getComb(i-1,k-1);
            int r=(c-l-s+m-1)%(m-1);
            ans=( (ans % m) * ((int)Math.pow(i,r) % m) ) % m;
        }
        return ans;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0)
	    {
	        int n=sc.nextInt();
	        int k=sc.nextInt();
	        for(int i=1;i<=n;i++)
	        {
	            int e=sc.nextInt();
	        }
	        System.out.println(solve(n,k));
	    }
	}
}
