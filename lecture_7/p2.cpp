#include<iostream>
#include<vector>
#include<climits>
using namespace std;

// not worked


bool isValid(vector<vector<int>>& grid,int r1,int c1,int r2,int c2)
{
    if(r1<grid.size() && r2<grid.size() && c1<grid[0].size() && c2<grid[0].size())
    {
        if(grid[r1][c1]!=-1 && grid[r2][c2]!=-1)
            return true;
    }
    return false;
}
int solve(vector<vector<int>>& grid,int r1,int c1,int r2,vector<vector<vector<int>>> strg)
{
    int x=0;
    int c2=r1+c1-r2;
    if(r1==r2 && c1==c2){
        if(r1==grid.size()-1 && c1==grid[0].size()-1)
            return grid[r1][c1];
        x=grid[r1][c1];
    }
    else{
        x+=grid[r1][c1]+grid[r2][c2];
    }
    if(strg[r1][c1][r2]!=-1)
        return strg[r1][c1][r2];
    int f1=INT_MIN,f2=INT_MIN,f3=INT_MIN,f4=INT_MIN;
    if(isValid(grid,r1,c1+1,r2,c2+1)==true)
        f1=solve(grid,r1,c1+1,r2,strg);
    if(isValid(grid,r1,c1+1,r2+1,c2)==true)
        f2=solve(grid,r1,c1+1,r2+1,strg);    
    if(isValid(grid,r1+1,c1,r2,c2+1)==true) 
        f3=solve(grid,r1+1,c1,r2,strg);
    if(isValid(grid,r1+1,c1,r2+1,c2)==true) 
        f4=solve(grid,r1+1,c1,r2+1,strg);
    int res=max(f1, max(f2, max(f3,f4)));
    if(res!=INT_MIN)
        res+=x;
    strg[r1][c1][r2]=res;
    return res;
}

int cherryPickup(vector<vector<int>>& grid) {
    vector<vector<vector<int>>> strg(grid.size(),
        vector<vector<int>>(grid.size(),
            vector<int>(grid.size(),-1)
        )
    );
    return max(0,solve(grid,0,0,0,strg));    
}

int main(int args,char** argv)
{
    vector<vector<int>> grid={
        {1,1,1,1,0,0,0},
        {0,0,0,1,0,0,0},
        {0,0,0,1,0,0,1},
        {1,0,0,1,0,0,0},
        {0,0,0,1,0,0,0},
        {0,0,0,1,0,0,0},
        {0,0,0,1,1,1,1}
    };
    cout<<cherryPickup(grid)<<endl;
    for(vector<int> a:grid)
    {
        for(int i:a)
            cout<<i<<" ";
        cout<<endl;
    }
    return 0;
}