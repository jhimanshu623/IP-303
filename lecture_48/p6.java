/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static long merge(int[] arr,int l,int m,int r)
    {
        int[] arr1=new int[m-l+1];
        int[] arr2=new int[r-m];
        for(int i=l;i<=m;i++)
        {
            arr1[i-l]=arr[i];
        }
        for(int i=m+1;i<=r;i++)
        {
            arr2[i-(m+1)]=arr[i];
        }
        int i=arr1.length-1;
        int j=arr2.length-1;
        int k=r;
        long count=0;
        while(i>=0 && j>=0)
        {
            if(arr1[i] > arr2[j])
            {
                count+=(j+1);
                arr[k]=arr1[i];
                k--;
                i--;
            }
            else
            {
                arr[k]=arr2[j];
                k--;
                j--;
            }
        }
        while(i>=0)
        {
            arr[k]=arr1[i];
            k--;
            i--;
        }
        while(j>=0)
        {
            arr[k]=arr2[j];
            k--;
            j--;
        }
        return count;
    }
    public static long solve(int[] nums,int l,int h)
    {
        if(l>=h)
            return 0;
        int mid=l+(h-l)/2;
        long count=0;
        count+=solve(nums, l, mid);
        count+=solve(nums, mid+1, h);
        count+=merge(nums,l,mid,h);
        return count;
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
        {
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            System.out.println(solve(arr,0,n-1));
        }
	}
}