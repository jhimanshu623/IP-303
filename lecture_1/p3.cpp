#include<iostream>
#include<vector>
using namespace std;

int minPathSum(vector<vector<int>>& grid) 
{
    vector<vector<int>> strg(grid.size(),vector<int>(grid[0].size(),0));
    for(int i=strg.size()-1;i>=0;i--)
    {
        for(int j=strg[0].size()-1;j>=0;j--)
        {
            if(i==strg.size()-1 && j==strg[0].size()-1)
                strg[i][j]=grid[i][j];
            else if(i==strg.size()-1)
                strg[i][j]=strg[i][j+1]+grid[i][j];
            else if(j==strg[0].size()-1)
                strg[i][j]=strg[i+1][j]+grid[i][j];
            else
            {
                strg[i][j]=min(strg[i+1][j],strg[i][j+1])+grid[i][j];
            }
        }
    }
    return strg[0][0];
}

int main(int args,char** argv)
{
    vector<vector<int>> grid={
        {1,3,1},
        {1,5,1},
        {4,2,1}
    };
    cout<<minPathSum(grid)<<endl;
    return 0;
}