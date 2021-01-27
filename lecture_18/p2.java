import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static long kConcatenationMaxSum(int[] nums, int k) {
        int n=nums.length;
        if(k>1)
            n=2*n;
        long cmax=Integer.MIN_VALUE;
        long omax=Integer.MIN_VALUE;
        for(int in=0;in<n;in++)
        {
            int i=in%nums.length;
            if(cmax>=0)
                cmax=cmax+nums[i];
            else
                cmax=nums[i];
            if(cmax>omax)
                omax=cmax;
        }
        if(k==1)
            return (omax);
        long sum=0;
        for(int i:nums)
            sum+=i;
        if(sum>0)
            return ((omax+(k-2)*sum));
        else
            return (omax);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0)
	    {
	        int n=sc.nextInt();
	        int k=sc.nextInt();
	        int nums[]=new int[n];
	        for(int i=0;i<n;i++)
	            nums[i]=sc.nextInt();
	        System.out.println(kConcatenationMaxSum(nums,k));
	    }
	}
}
