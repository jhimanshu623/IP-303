class Solution {
public:
    int dir[4][2]={
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    void dfs(vector<vector<int>>& grid,int r,int c,int color)
    {
        int count=0;
        int mc=grid[r][c];
        grid[r][c]=1001;
        for(int d=0;d<4;d++)
        {
            int nr=r+dir[d][0];
            int nc=c+dir[d][1];
            if(nr>=0 && nc>=0 && nr<grid.size() && nc<grid[0].size())
            {
                if(grid[nr][nc]==1001)
                    count++;
                else if(grid[nr][nc]==mc)
                {
                    count++;
                    dfs(grid,nr,nc,color);
                }
            }
        }
        if(count==4)
            grid[r][c]=mc;
    }
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int r0, int c0, int color) {
        dfs(grid,r0,c0,color);
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[i].size();j++)
            {
                if(grid[i][j]==1001)
                    grid[i][j]=color;
            }
        }
        return grid;
    }
};