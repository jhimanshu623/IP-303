/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int countWays(int n)
    {
        int z=1;
        int o=1;
        int mod=1000000007;
        for(int i=2;i<=n;i++)
        {
            int nz=(o%mod + z%mod)%mod;
            int no=z;
            z=nz;
            o=no;
        }
        return (z%mod + o%mod)%mod;
        
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    System.out.println(countWays(n));
		}
	}
}