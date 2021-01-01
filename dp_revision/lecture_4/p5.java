/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class p5 {
    public static int countWays(int n)
    {
        int h=1;
        int e=1;
        for(int i=2;i<=n;i++)
        {
           int nh=e;
           int ne=h+e;
           h=nh;
           e=ne;
        }
        return (h+e)*(h+e);   
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