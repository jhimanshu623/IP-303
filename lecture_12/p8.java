

class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || s.length()<t.length())
            return "";
        HashMap<Character,Integer> maps=new HashMap<>();
        HashMap<Character,Integer> mapt=new HashMap<>();
        for(char ch:t.toCharArray())
            mapt.put(ch,mapt.getOrDefault(ch,0)+1);
        int st=0;
        int end=-1;
        int mc=0;
        int res=s.length()+1;
        String ans="";
        while(end<s.length()-1)
        {
            end++;
            char ch=s.charAt(end);
            maps.put(ch,maps.getOrDefault(ch,0)+1);
            if(mapt.containsKey(ch) && maps.get(ch)<=mapt.get(ch))
                mc++;
            while(mc==t.length())
            {
                if((end-st+1) < res){
                    res=end-st+1;
                    ans=s.substring(st,end+1);
                }
                ch=s.charAt(st);
                if(mapt.containsKey(ch) && maps.get(ch)<=mapt.get(ch))
                    mc--;
                maps.put(ch,maps.get(ch)-1);
                st++;
            }
        }
        return ans;
    }
}