class Solution {
public:
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    void dfs(vector<vector<int>> &grid,int r,int c,string& s)
    {
        grid[r][c]=0;
        if(c+1<grid[0].size() && grid[r][c+1]==1)
        {
            s+="r";
            dfs(grid,r,c+1,s);
        }
        if(r+1<grid.size() && grid[r+1][c]==1)
        {
            s+="d";
            dfs(grid,r+1,c,s);
        }
        if(c-1>=0 && grid[r][c-1]==1)
        {
            s+="l";
            dfs(grid,r,c-1,s);
        }
        if(r-1>=0 && grid[r-1][c]==1)
        {
            s+="u";
            dfs(grid,r-1,c,s);
        }
        s+="x";
    }
    int numberofDistinctIslands(vector<vector<int>> &grid) {
        unordered_set<string> isTaken;
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[i].size();j++)
            {
                if(grid[i][j]==1)
                {
                    string s="";
                    dfs(grid,i,j,s);
                    isTaken.insert(s);
                }
            }
        }
        return isTaken.size();
    }
};