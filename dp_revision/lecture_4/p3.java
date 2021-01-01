public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if(costs.length==0)
            return 0;
        int min=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        for(int j=0;j<costs[0].length;j++)
        {
            if(costs[0][j] < min)
            {
                min2=min;
                min=costs[0][j];
            }
            else if(costs[0][j] < min2)
            {
                min2=costs[0][j];
            }
        }
        for(int i=1;i<costs.length;i++)
        {
            int tmin=Integer.MAX_VALUE;
            int tmin2=Integer.MAX_VALUE;
            for(int j=0;j<costs[0].length;j++)
            {
                if(costs[i-1][j]!=min)
                    costs[i][j]=costs[i][j]+min;
                else
                    costs[i][j]=costs[i][j]+min2;
                if(costs[i][j] < tmin)
                {
                    tmin2=tmin;
                    tmin=costs[i][j];
                }
                else if(costs[i][j] < tmin2)
                {
                    tmin2=costs[i][j];
                }   
            }
            min=tmin;
            min2=tmin2;
        }
        return min;
    }
}