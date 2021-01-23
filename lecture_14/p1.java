/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class Pair implements Comparable<Pair>
    {
        char ch;
        int f;
        Pair(char ch,int f)
        {
            this.ch=ch;
            this.f=f;
        }
        public int compareTo(Pair other)
        {
            return other.f-this.f;
        }
    }
    public static boolean solve(String s)
    {
        int[] map=new int[26];
        for(char ch:s.toCharArray())
            map[ch-'a']++;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<26;i++)
        {
            if(map[i]>0)
                pq.add(new Pair((char)(i+'a'),map[i]));
        }
        Pair rp=pq.poll();
        StringBuilder str=new StringBuilder();
        str.append(rp.ch);
        rp.f--;
        Pair prev=rp;
        while(pq.size()>0)
        {
            rp=pq.poll();
            str.append(rp.ch);
            rp.f--;
            if(prev.f>0)
                pq.add(prev);
            prev=rp;
        }
        return (prev.f==0);
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    String s=sc.next();
		    System.out.println(solve(s)?1:0);
		}
	}
}