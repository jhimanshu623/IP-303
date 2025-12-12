import java.util.*;
import java.lang.*;

class Main
{
    public static long solve(int n,int p)
    {
        if(n>=p)
            return 0;
        long ans=(p-1);
        for(int i=1;n+i<=p-1;i++)
        {
            ans=( (ans%p) *  ((int)(Math.pow(n+i,p-2)) % p) ) % p; 
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
            int p=sc.nextInt();
            System.out.println(solve(n,p));
        }
	}
}