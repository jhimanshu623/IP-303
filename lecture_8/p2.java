
public class p2 {
    public static boolean solve(String s1,String s2,int i,int j,int len,int strg[][][])
    {
        if(len==1)
            return (s1.charAt(i)==s2.charAt(j));
        if(strg[i][j][len]!=0)
            return (strg[i][j][len] == 1?true:false);
        boolean res=false;

        // ONE OPTIMIZATION CAN BE DONE HERE BY CHECKING IF STRINGS HAVE SAME 
        // CHARACTERS WITH SAME FREQUENCY.

        for(int l=1;l<len;l++)
        {
            if(solve(s1,s2,i,j,l,strg) && solve(s1,s2,i+l,j+l,len-l,strg))
                res=true;
            if(!res && solve(s1,s2,i,j+len-l,l,strg) && solve(s1,s2,i+l,j,len-l,strg))
                res=true;
        }
        strg[i][j][len]=(res==true)?1:-1;
        return res;
    }
    public static boolean isScramble(String s1, String s2) {
        int strg[][][]=new int[s1.length()][s2.length()][s1.length()+1];
        return solve(s1,s2,0,0,s1.length(),strg);
    }


    // tabulation
    public static boolean isScramble_02(String s1,String s2)
    {
        if(s1.length()==0)
            return false;
        boolean strg[][][]=new boolean[s1.length()][s1.length()][s1.length()+1];
        for(int len=1;len<=s1.length();len++)
        {
            for(int i=0;i<=strg.length-len;i++)
            {
                for(int j=0;j<=strg[0].length-len;j++)
                {
                    if(len==1)
                        strg[i][j][len]=(s1.charAt(i)==s2.charAt(j));
                    else
                    {
                        boolean res=false;
                        for(int l=1;l<len;l++)
                        {
                            if(strg[i][j][l] && strg[i+l][j+l][len-l])
                                res=true;
                            if(!res && strg[i][j+len-l][l] && strg[i+l][j][len-l])
                                res=true;
                        }
                        strg[i][j][len]=res;
                    }
                    
                }
            }
        }
        return strg[0][0][s1.length()];
    }
    public static void main(String args[])
    {
        String s1="abcde";
        String s2="caebd";
        System.out.println(isScramble(s1,s2));
        System.out.println(isScramble_02(s1,s2));
    }
}