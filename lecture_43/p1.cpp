#include<iostream>
#include<vector>
using namespace std;

vector<vector<int>> g;

void addEdge(int u,int v)
{
    g[u].push_back(v);
    g[v].push_back(u);
}
void display()
{
    for(int u=0;u<g.size();u++)
    {
        cout<<u<<"-> ";
        for(int v=0;v<g[u].size();v++)
        {
            int nv=g[u][v];
            cout<<nv<<", ";
        }
        cout<<endl;
    }
}

int *disc;
int *low;
bool *vis;
int ap;
int os;
int children;
int counter;
void dfs(int u,int par)
{
    vis[u]=true;
    disc[u]=counter;
    low[u]=counter;
    counter++;
    bool flag=false;
    for(int n=0;n<g[u].size();n++)
    {
        int nv=g[u][n];
        if(nv==par)
            continue;
        else if(vis[nv]==true)
            low[u]=min(low[u],disc[nv]);
        else
        {
            if(u==os)
                children++;
            dfs(nv,u);
            low[u]=min(low[u],low[nv]);
            if(disc[u]<=low[nv] && u!=os &&flag==false)
            {
                ap++;
                flag=true;
            }
        }
    }
}

int articulationPoints(int n)
{
    disc=new int[n];
    low=new int[n];
    vis=new bool[n];
    for(int i=0;i<n;i++)
        vis[i]=false;
    ap=0;
    os=1;
    children=0;
    counter=0;
    dfs(1,0);
    if(children>=2)
        ap++;
    return ap;
}
int main(int args,char** argv)
{
    int t;
    cin>>t;
    while(t-->0)
    {
        int n;
        cin>>n;
        int m;
        cin>>m;
        g.assign(n+1,vector<int>(0));
        for(int i=0;i<m;i++)
        {
            int u,v;
            cin>>u;
            cin>>v;
            addEdge(u,v);
        }
        cout<<articulationPoints(g.size())<<endl;
    }
    return 0;
}