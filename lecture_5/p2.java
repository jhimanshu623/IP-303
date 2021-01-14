public class p2 {

    // O(n2) space
    public static int editDistance(String s1,String s2)
    {
        int strg[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<strg.length;i++)
        {
            for(int j=0;j<strg[0].length;j++)
            {
                if(i==0 && j==0)
                    strg[i][j]=0;
                else if(i==0)
                {
                    strg[i][j]=j;
                }
                else if(j==0)
                {
                    strg[i][j]=i;
                }
                else
                {
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        strg[i][j]=strg[i-1][j-1];
                    else
                        strg[i][j]=Math.min(strg[i-1][j-1],Math.min(strg[i-1][j],strg[i][j-1]))+1;
                }
            }
        }
        return strg[strg.length-1][strg[0].length-1];
    }

    // O(n) space
    public static int editDistance_02(String s1, String s2) {
        int strg[]=new int[s2.length()+1];
        for(int i=0;i<strg.length;i++)
            strg[i]=i;
        for(int i=1;i<=s1.length();i++)
        {
            int pre=strg[0];
            strg[0]=i;
            for(int j=1;j<=s2.length();j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    int tmp=strg[j];
                    strg[j]=pre;
                    pre=tmp;
                }
                else
                {
                    int tmp=strg[j];
                    strg[j]=Math.min(pre,Math.min(strg[j],strg[j-1]))+1;
                    pre=tmp;
                }
            }
        }
        return strg[s2.length()]; 
    }
    public static void main(String args[])
    {
        String s1="intention";
        String s2="execution";
        System.out.println(editDistance(s1,s2));
        System.out.println(editDistance_02(s1,s2));
    }
}