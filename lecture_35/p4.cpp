#include<iostream>
using namespace std;

void dfs_(vector<int> g[],vector<int>& visited,int s,vector<int>& res)
{
    visited[s]=true;
    res.push_back(s);
    for(int n=0;n<g[s].size();n++)
    {
        int v=g[s][n];
        if(visited[v]==false)
            dfs_(g,visited,v,res);
    }
}
vector <int> dfs(vector<int> g[], int n)
{
    vector<int> res;
    vector<int> visited(n,false);
    dfs_(g,visited,0,res);
    return res;
}

int main(int args,char** argv)
{
    return 0;
}