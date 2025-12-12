#include<iostream>
using namespace std;

bool isBipartiteComp(vector<vector<int>>& graph,vector<int> visited,int src)
{
    queue<pair<int,int>> que;
    que.push({src,0});
    while(que.size()>0)
    {
        pair<int,int> rp=que.front();
        que.pop();
        if(visited[rp.first]!=-1)
        {
            if(visited[rp.first]!=rp.second)
                return false;
            continue;
        }
        visited[rp.first]=rp.second;
        for(int n=0;n<graph[rp.first].size();n++)
        {
            int e=graph[rp.first][n];
            if(visited[e]==-1)
                que.push({e,1-rp.second});
        }
    }
    return true;
}

bool isBipartite(vector<vector<int>>& graph) {
    vector<int> visited(graph.size(),-1);
    for(int i=0;i<graph.size();i++)
    {
        if(visited[i]==-1)
        {
            bool res=isBipartiteComp(graph,visited,i);
            if(res==false)
                return res;
        }
    }
    return true;
}

int main(int args,char** argv)
{
    return 0;
}