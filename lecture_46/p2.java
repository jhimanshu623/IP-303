class Solution {
    public int findLps(String s)
    {
        int[] lps=new int[s.length()];
        int i=1;
        int len=0;
        while(i<s.length())
        {
            if(s.charAt(len)==s.charAt(i))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if(len>0)
                    len=lps[len-1];
                else
                    i++;
            }
        }
        return lps[lps.length-1];
    }
    public String shortestPalindrome(String s) {
        String str="";
        for(int i=s.length()-1;i>=0;i--)
        {
            str+=s.charAt(i);
        }
        String a=s+"#"+str;
        int l=findLps(a);
        String ans="";
        for(int i=0;i<str.length()-l;i++)
        {
            ans+=str.charAt(i);
        }
        for(int i=0;i<s.length();i++)
        {
            ans+=s.charAt(i);
        }
        return ans;
    }
}