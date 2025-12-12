#include<iostream>
#include<vector>
using namespace std;
 
vector <int> bfs(vector<int> g[], int n) {
    vector<int> res;
    vector<bool> visited(n,false);
    queue<int> que;
    que.push(0);
    while(que.size()>0)
    {
        int rv=que.front();
        que.pop();
        if(visited[rv]==true)
            continue;
        res.push_back(rv);
        visited[rv]=true;
        for(int i=0;i<g[rv].size();i++)
        {
            int e=g[rv][i];
            if(visited[e]==false)
                que.push(e);
        }
    }
    return res;
}

int main(int args,char** argv)
{
    return 0;
}