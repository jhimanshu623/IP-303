class Solution {
public:
    void solve(vector<vector<char>>& grid,int r,int c)
    {
        if(grid[r][c]=='0')
           return;
        grid[r][c]='0';
        if(r-1>=0)
            solve(grid,r-1,c);
        if(c+1<grid[0].size())
            solve(grid,r,c+1);
        if(r+1<grid.size())
            solve(grid,r+1,c);
        if(c-1>=0)
            solve(grid,r,c-1);
    }
    int numIslands(vector<vector<char>>& grid) {
        int count=0;
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[i].size();j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    solve(grid,i,j);
                }
            }
        }
        return count;
    }
};