#include<iostream>
#include<vector>
using namespace std;

string printPath(vector<vector<int>>&,vector<vector<int>>&);
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
    cout<<"path is:"<<printPath(grid,strg)<<endl;
    return strg[0][0];
}

string printPath(vector<vector<int>>& grid,vector<vector<int>>& strg)
{
    int i=0;
    int j=0;
    string ans="";
    while(!(i==strg.size()-1 && j==strg[0].size()-1))
    {
        int f=strg[i][j]-grid[i][j];
        cout<<strg[i][j]<<"   "<<f<<endl;
        if(j+1<grid[0].size() &&  f==strg[i][j+1]){
            ans+="H ";
            j++;
        }
        else{
            ans+="V ";
            i++;
        }
    }
    return ans;
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