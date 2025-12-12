#include<queue>
#include<climits>
using namespace std;

int **g;
int *par;
bool *vis;
int gs;

bool bfs()
{
    par=new int[gs];
    vis=new bool[gs];
    for(int i=0;i<gs;i++){
        vis[i]=false;
        par[i]=-1;
    }
    queue<int> que;
    que.push(1);
    vis[1]=true;
    while(que.size()>0)
    {
        int rv=que.front();
        que.pop();
        
        for(int n=0;n<gs;n++)
        {
            if(g[rv][n]!=0 && vis[n]==false)
            {
                que.push(n);
                par[n]=rv;
                vis[n]=true;
            }
        }
    }
    if(par[gs-1]!=-1)
        return true;
    else
        return false;
}
int maxFlow(int st,int dest)
{
    int ans=0;
    while(bfs()==true)
    {
        int minPath=INT_MAX;
        for(int v=dest;v!=st;v=par[v])
        {
            int u=par[v];
            minPath=min(minPath,g[u][v]);
        }
        for(int v=dest;v!=st;v=par[v])
        {
            int u=par[v];
            g[u][v]-=minPath;
            g[v][u]+=minPath;
        }
        ans+=minPath;
    }
    return ans;
}

int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        int n;
        cin>>n;
        int m;
        cin>>m;
        g=new int*[n+1];
        gs=n+1;
        for(int i=0;i<=n;i++){
            g[i]=new int[n+1];
            for(int j=0;j<=n;j++)
            {
                g[i][j]=0;
            }
        }
        for(int i=0;i<m;i++)
        {
            int u;
            cin>>u;
            int v;
            cin>>v;
            int wt;
            cin>>wt;
            g[u][v]+=wt;
            g[v][u]+=wt;
        }
        cout<<maxFlow(1,n)<<endl;
    }
	return 0;
}