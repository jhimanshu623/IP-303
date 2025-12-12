import java.util.*;
import java.lang.*;
import java.io.*;

public class p1 {
    public static int[] findLps(String s)
    {
        int[] lps=new int[s.length()];
        int i=1;
        int len=0;
        int ans=0;
        while(i<s.length())
        {
            if(s.charAt(len)==s.charAt(i))
            {
                len++;
                lps[i]=len;
                ans=Math.max(ans,lps[i]);
                i++;
            }
            else
            {
                if(len>0)
                    len=lps[len-1];
                else
                {
                    lps[i]=0;
                    i++;
                }
            }
        }
        // return ans;
        return lps;
    }
    public static void kmp(String text,String pat)
    {
        String s=pat+"#"+text;
        int[] lps=findLps(s);
        for(int i:lps)
            System.out.print(i+" ");
        System.out.println();
        for(int i=0;i<lps.length;i++)
        {
            if(lps[i]==pat.length())
                System.out.println(i - (pat.length()-1) - (pat.length()+1));
        }
        System.out.println();
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		// int t=sc.nextInt();
		// while(t-->0)
		// {
		//     String s=sc.next();
		//     System.out.println(findLps(s));
        // }
        kmp("aabaacaabaad","aab");
	}
}