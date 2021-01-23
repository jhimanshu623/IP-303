class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans=0;
        int[][] dir={
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    ans+=4;
                    for(int d=0;d<4;d++)
                    {
                        int nr=i+dir[d][0];
                        int nc=j+dir[d][1];
                        if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1)
                            ans--;
                    }
                }
            }
        }
        return ans;
    }
}