#include<iostream>
#include<vector>
using namespace std;

int minTotalDistance(vector<vector<int>> &grid) {
    vector<int> row;
    vector<int> col;
    for(int r=0;r<grid.size();r++)
    {
        for(int c=0;c<grid[r].size();c++)
        {
            if(grid[r][c]==1)
                row.push_back(r);
        }
    }
    for(int c=0;c<grid[0].size();c++)
    {
        for(int r=0;r<grid.size();r++)
        {
            if(grid[r][c]==1)
                col.push_back(c);
        }
    }
    int ar=row[row.size()/2];
    int ac=col[col.size()/2];
    int ans=0;
    for(int r=0;r<grid.size();r++)
    {
        for(int c=0;c<grid[0].size();c++)
        {
            if(grid[r][c]==1)
            {
                ans+=abs(ar-r)+abs(ac-c);
            }
        }
    }
    return ans;
}
int main(int args,char** argv)
{
    vector<vector<int>> grid={
        {1,0,0,0,1},
        {0,0,0,0,0},
        {0,0,1,0,0}
    };
    cout<<minTotalDistance(grid)<<endl;
    return 0;
}