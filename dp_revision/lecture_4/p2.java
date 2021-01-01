public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public static int minCost(int ques[][])
    {
        if(ques.length==0)
            return  0;
        for(int i=1;i<ques.length;i++)
        {
            for(int j=0;j<ques[0].length;j++)
            {
                int min=Integer.MAX_VALUE;
                for(int k=0;k<ques[0].length;k++)
                {
                    if(k!=j)
                        min=Math.min(min,ques[i-1][k]);
                }
                ques[i][j]=ques[i][j]+min;
            }
        }

        int min=Integer.MAX_VALUE;
        for(int k=0;k<ques[0].length;k++)
        {
            min=Math.min(min,ques[ques.length-1][k]);
        }
        return min;
    }
}