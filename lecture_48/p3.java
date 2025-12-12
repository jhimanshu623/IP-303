/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class p3 {
    public static int[] countingSort(int[] nums)
    {
        int mv=Integer.MIN_VALUE;
        for(int i:nums)
            mv=Math.max(mv,i);
        int[] freq=new int[mv+1];
        for(int i:nums)
            freq[i]++;
        for(int i=1;i<freq.length;i++)
        {
            freq[i]=freq[i]+freq[i-1];
        }
        int[] res=new int[nums.length];
        for(int i:nums)
        {
            res[nums.length-freq[i]]=i;
            freq[i]--;
        }
        
        return res;
    }
    public static int solve(String s)
    {
        int[] nums=new int[s.length()];
        for(int i=0;i<nums.length;i++)
            nums[i]=s.charAt(i)-'0';
        
        nums=countingSort(nums);
        
        if(nums[nums.length-1]%2!=0)
        {
            for(int i=nums.length-2;i>=0;i--){
                if(nums[i]%2==0)
                {
                    int t=nums[nums.length-1];
                    nums[nums.length-1]=nums[i];
                    nums[i]=t;
                    break;
                }
            }   
        }
        for(int i:nums)
            System.out.print(i);
        System.out.println();
        return 0;
    }
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0)
	    {
	        String n=sc.next();
	        solve(n);
	    }
	}
}