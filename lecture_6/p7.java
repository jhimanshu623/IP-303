
public class p7 {

    public static int optimalBST(int[] nodes,int[] freq)
    {
        int strg[][]=new int[nodes.length][nodes.length];
        for(int g=0;g<strg.length;g++)
        {
            for(int i=0;i<strg.length-g;i++)
            {
                int j=i+g;
                if(g==0)
                    strg[i][j]=freq[i];
                else if(g==1)
                {
                    strg[i][j]=Math.min((freq[i] + 2*freq[j]) , (freq[j] + 2*freq[i]));
                }
                else
                {
                    int min=Integer.MAX_VALUE;
                    int f=0;
                    for(int k=0;k<=g;k++)
                    {
                        int left=(k==0)?0:strg[i][i+k-1];
                        int right=(k==g)?0:strg[i+1+k][j];
                        int tc=left+right;
                        f+=freq[i+k];
                        if(tc<min)
                            min=tc;
                    }
                    strg[i][j]=min+f;
                }
            }
        }
        return strg[0][strg.length-1];
    }

    public static void main(String args[])
    {
        int nodes[]={10,20,30,40,50,60,70};
        // int freq[]={2,1,3,5,1,8,4};
        int freq[]={2,1,4,1,1,3,5};
        System.out.println(optimalBST(nodes,freq));
    }
}