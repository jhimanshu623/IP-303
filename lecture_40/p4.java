class Solution {
    ArrayList<Integer>[] g;
    public void addEdge(int u,int v)
    {
        g[u].add(v);
    }
    public boolean dfs(int s,boolean[] visited,Stack<Integer> st, boolean[] lvis)
    {
        visited[s]=true;
        lvis[s] = true;
        for(int n=0;n<g[s].size();n++)
        {
            int nv=g[s].get(n);
            // if(lvis[nv])
            //     return false;
            if(visited[nv]==false) {
                if(!dfs(nv,visited,st, lvis)) return false;
            }
            else if(lvis[nv])
                return false;
        }
        lvis[s] = false;
        st.push(s);
        return true;
    }
    
    public int[] topologicalSort(int n)
    {
        int[] res=new int[n];
        Arrays.fill(res,-1);
        boolean[] visited=new boolean[g.length];
        Stack<Integer> st=new Stack<>();
        for(int i=n;i<g.length;i++)
        {
            if(visited[i]==false)
                if(!dfs(i,visited,st, new boolean[g.length]))
                    return new int[0];
        }
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
                if(!dfs(i,visited,st,new boolean[g.length]))
                    return new int[0];
        }
        int c=0;
        while(st.size()>0)
        {
            int v=st.pop();
            if(v<n){
                res[c++]=v;
            }
        }
        return res;
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        g=new ArrayList[n+2*m];
        for(int i=0;i<g.length;i++)
            g[i]=new ArrayList<>();
        for(int i=0;i<group.length;i++)
        {
            if(group[i]==-1)
                continue;
            else
            {
                int gs=n+2*group[i];
                int ge=gs+1;
                addEdge(gs,i);
                addEdge(i,ge);
            }
        }
        
        for(int i=0;i<beforeItems.size();i++)
        {
            for(int j=0;j<beforeItems.get(i).size();j++)
            {
                int bf=beforeItems.get(i).get(j);
                if(group[bf]==-1 && group[i]==-1)
                {
                    addEdge(bf,i);
                }
                else if(group[bf]==-1 && group[i]!=-1)
                {
                    addEdge(bf,g[i].get(0)-1);
                }
                else if(group[bf]!=-1 && group[i]==-1)
                {
                    addEdge(g[bf].get(0),i);
                }
                else
                {
                    if(group[bf] == group[i])
                        addEdge(bf,i);
                    else
                        addEdge(g[bf].get(0),g[i].get(0)-1);
                }
            }
        }
        return topologicalSort(n);
    }
}