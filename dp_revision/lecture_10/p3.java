class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        int[] fmap1=new int[256];
        int[] fmap2=new int[256];
        for(int i=0;i<s1.length();i++){
            fmap1[s1.charAt(i)-'a']++;
            fmap2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<256;i++)
        {
            if(fmap1[i]!=fmap2[i])
                return false;
        }
        
        for(int i=1;i<s1.length();i++)
        {
            if(isScramble(s1.substring(0,i) ,s2.substring(0,i)) && isScramble(s1.substring(i) , s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0,i) ,s2.substring(s2.length()-i)) && isScramble(s1.substring(i) , s2.substring(0,s2.length()-i)))
                return true;
        }
        return false;
    }
}