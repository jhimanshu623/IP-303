public class p1
{
    public static int lcs(String s1,String s2,String s3)
    {
        int strg[][][]=new int[s1.length()+1][s2.length()+1][s3.length()+1];
        for(int i=strg.length-1;i>=0;i--)
        {
            for(int j=strg[0].length-1;j>=0;j--)
            {
                for(int k=strg[0][0].length-1;k>=0;k--)
                {
                    if(i==strg.length-1 || j==strg[0].length-1 || k==strg[0][0].length-1)
                        strg[i][j][k]=0;
                    else if((s1.charAt(i)==s2.charAt(j)) && (s2.charAt(j)==s3.charAt(k)))
                        strg[i][j][k]=1+strg[i+1][j+1][k+1];
                    else
                    {
                        strg[i][j][k]=Math.max(strg[i+1][j][k],Math.max(strg[i][j+1][k],strg[i][j][k+1]));
                    }
                }
            }
        }
        return strg[0][0][0];
    }
    public static void main(String args[])
    {
        String s1="geeks";
        String s2="geeksfor";
        String s3="geeksforgeeks";
        System.out.println(lcs(s1,s2,s3));
    }
}