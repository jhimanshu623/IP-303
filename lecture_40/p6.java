class Solution {
    ArrayList<Integer>[] g;
    public void addEdge(int u,int v)
    {
        g[u].add(v);
        g[v].add(u);
    }
    public boolean isBipartiteComp(int[] visited,int s)
    {
        LinkedList<Integer> que=new LinkedList<>();
        visited[s]=1;
        que.addLast(s);
        while(que.size()>0)
        {
            int rp=que.removeFirst();
            int grp=visited[rp];
            for(int n=0;n<g[rp].size();n++)
            {
                int nv=g[rp].get(n);
                if(visited[nv]!=0)
                {
                    if(visited[nv] != 3-grp)
                        return false;
                }
                else{
                    visited[nv]=3-grp;
                    que.addLast(nv);
                }   
            }
        }
        return true;
    }
    public boolean isBipartite()
    {
        int[] visited=new int[g.length];
        for(int i=0;i<g.length;i++)
        {
            if(visited[i]==0)
            {
                boolean res=isBipartiteComp(visited,i);
                if(res==false)
                    return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        g=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            g[i]=new ArrayList<>();
        for(int i=0;i<dislikes.length;i++)
            addEdge(dislikes[i][0],dislikes[i][1]);
        return isBipartite();
    }
}