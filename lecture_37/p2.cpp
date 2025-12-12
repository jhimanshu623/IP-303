void dfs(int s,vector<bool>& vis,stack<int>& st,vector<int> g[],int& count)
{
    vis[s]=true;
    count++;
    for(int n=0;n<g[s].size();n++)
    {
        int nv=g[s][n];
        if(vis[nv]==false)
        {
            dfs(nv,vis,st,g,count);
        }
    }
    st.push(s);
}

int findMother(int n, vector<int> g[]) 
{ 
    vector<bool> vis(n,false);
    stack<int> st;
    
    // build stack
    int count=0;
    for(int i=0;i<n;i++)
    {
        if(vis[i]==false)
        {
            dfs(i,vis,st,g,count);
        }
    }
    
    for(int i=0;i<n;i++)
        vis[i]=false;
    count=0;
    dfs(st.top(),vis,st,g,count);
    if(count==n)
        return st.top();
    return -1;
} 