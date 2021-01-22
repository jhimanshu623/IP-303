/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static boolean anagramPalindrome(String s)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        int count=0;
        for(char ch:map.keySet())
            if(map.get(ch)%2!=0)
                count++;
        return count<=1;
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    String s=sc.next();
		    boolean res=anagramPalindrome(s);
		    System.out.println((res==true)?"Yes":"No");
		}
	}
}