import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static long friendsPair(int n)
    {
        long strg[]=new long[n+1];
        strg[0]=1;
        strg[1]=1;
        int mod=(int)(Math.pow(10,9))+7;
        for(int i=2;i<=n;i++)
        {
            strg[i]=(strg[i-1]+((i-1)*strg[i-2])%mod)%mod;
        }
        
        return strg[n];
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    System.out.println(friendsPair(n));
		}
	}
}