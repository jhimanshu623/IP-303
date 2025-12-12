import java.util.*;
import java.lang.*;

public class p5
{
	static int[] temp;
	public static void process(int[] arr,int n,int bs)
	{
		for(int i=0;i<n;i++)
		{
			int idx=i/bs;
			temp[idx]=Math.min(temp[idx],arr[i]);
		}
	}
	public static int solveQuery(int[] arr,int l,int r,int n,int bs)
	{
		int ans=Integer.MAX_VALUE;
		while(l<=r)
		{
			int idx=l/bs;
			if(l%bs==0)
			{
				if(r>=l+bs-1)
				{
					ans=Math.min(ans,temp[idx]);
					l=l+bs;
				}
				else
				{
					ans=Math.min(ans,arr[l]);
					l++;
				}
			}
			else
			{
				ans=Math.min(ans,arr[l]);
				l++;
			}
		}
		return ans;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		int bs=(int)Math.ceil(Math.sqrt(n));
		temp=new int[bs];
		Arrays.fill(temp,Integer.MAX_VALUE);
		process(arr,n,bs);
		int q=sc.nextInt();
		while(q-->0)
		{
			int l=sc.nextInt();
			int r=sc.nextInt();
			System.out.println(solveQuery(arr,l,r,n,bs));
		}
	}
}