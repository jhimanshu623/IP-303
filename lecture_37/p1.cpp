void dfs(int s,vector<bool>& vis,stack<int>& st,vector<int> g[])
{
    vis[s]=true;
    for(int n=0;n<g[s].size();n++)
    {
        int nv=g[s][n];
        if(vis[nv]==false)
        {
            dfs(nv,vis,st,g);
        }
    }
    st.push(s);
}
// dfs for reversed edges graph
void dfs(int s,vector<bool>& vis,vector<vector<int>>& g)
{
    vis[s]=true;
    for(int n=0;n<g[s].size();n++)
    {
        int nv=g[s][n];
        if(vis[nv]==false)
        {
            dfs(nv,vis,g);
        }
    }
}
void reverseEdges(int n,vector<int> g[],vector<vector<int>>& ng)
{
    for(int u=0;u<n;u++)
    {
        for(int v=0;v<g[u].size();v++)
        {
            int nv=g[u][v];
            ng[nv].push_back(u);
        }
    }
}
int kosaraju(int n, vector<int> g[])
{
    vector<bool> vis(n,false);
    stack<int> st;
    
    // step 1
    // build stack
    for(int i=0;i<n;i++)
    {
        if(vis[i]==false)
        {
            dfs(i,vis,st,g);
        }
    }
    
    // step 2
    // reverse edges
    vector<vector<int>> ng(n,vector<int>(0));
    reverseEdges(n,g,ng);
    
    // step 3
    int scc=0;
    for(int i=0;i<n;i++)
        vis[i]=false;
    while(st.size()>0)
    {
        int s=st.top();st.pop();
        if(vis[s]==false)
        {
            scc++;
            dfs(s,vis,ng);
        }
    }
    return scc;
}