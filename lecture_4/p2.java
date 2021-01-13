
public class p2 {
    public static int caps(String s)
    {
        if(s.length()==0)
            return 0;
        int strg[][]=new int[s.length()][s.length()];
        for(int g=0;g<s.length();g++)
        {
            for(int i=0;i<s.length()-g;i++)
            {
                int j=i+g;
                if(g==0)
                    strg[i][j]=1;
                else if(g==1)
                {
                    if(s.charAt(i)==s.charAt(j))
                        strg[i][j]=3;
                    else
                        strg[i][j]=2;
                }
                else
                {
                    if(s.charAt(i)==s.charAt(j))
                        strg[i][j]=strg[i][j-1]+strg[i+1][j]+1;
                    else
                        strg[i][j]=strg[i][j-1]+strg[i+1][j]-strg[i+1][j-1];   
                }
            }
        }
        return strg[0][s.length()-1];
    }
    public static void main(String args[])
    {
        String s="aab";
        System.out.println(caps(s));
    }
}