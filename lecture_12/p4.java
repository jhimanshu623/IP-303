import java.util.*;
public class p4 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if(s.length()==0 || s.length()<p.length())
            return res;
        HashMap<Character,Integer> smap=new HashMap<>();
        HashMap<Character,Integer> pmap=new HashMap<>();
        int mc=0;
        for(int i=0;i<p.length();i++)
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);
        for(int i=0;i<p.length();i++)
        {
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            if(pmap.containsKey(s.charAt(i)) && smap.get(s.charAt(i))<=pmap.get(s.charAt(i)))
                mc++;
            if(mc==p.length())
                res.add(0);
        }
        int st=0;
        int en=p.length()-1;
        while(en!=s.length()-1)
        {
            en++;
            char c=s.charAt(en);
            smap.put(c,smap.getOrDefault(c,0)+1);
            if(pmap.containsKey(c) && smap.get(c)<=pmap.get(c))
                mc++;
            c=s.charAt(st);
            st++;
            if(pmap.containsKey(c) && smap.get(c)<=pmap.get(c))
                mc--;
            smap.put(c,smap.get(c)-1);
            if(mc==p.length())
                res.add(st);
        }
        return res;
    }
    
    public static void main(String[] args) {
        String s="dcbaebabacd";
        String t="abc";
        List<Integer> res=findAnagrams(s,t);
        for(int i:res)
            System.out.print(i+", ");
    }
}