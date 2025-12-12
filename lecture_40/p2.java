class Solution {
    int[] par;
    int[] rank;
    int[] indegree;
    ArrayList<Integer>[] g;
    public int find(int x)
    {
        if(par[x]==x)
            return x;
        int px=find(par[x]);
        par[x]=px;
        return px;
    }
    public void merge(int xl,int yl)
    {
        if(rank[xl]<rank[yl])
            par[xl]=yl;
        else if(rank[yl]<rank[xl])
            par[yl]=xl;
        else
        {
            par[xl]=yl;
            rank[yl]++;
        }
    }
    public int isCloseFigure(int[][] edges,int bl) {
        int n=edges.length;
        par=new int[n+1];
        rank=new int[n+1];
        int[] res=new int[2];
        for(int i=0;i<=n;i++)
        {
            par[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<n;i++)
        {
            if(i==bl)
                continue;
            int x=edges[i][0];
            int y=edges[i][1];
            int xl=find(x);
            int yl=find(y);
            if(xl==yl)
                return i;
            else
                merge(xl,yl);
        }
        return -1;
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        indegree=new int[n+1];
        int[] res=new int[2];
        Arrays.fill(indegree,-1);
        int bl=-1;
        int pa=-1;
        for(int i=0;i<n;i++)
        {
            int v=edges[i][1];
            if(indegree[v]!=-1)
            {
                pa=indegree[v];
                bl=i;
                break;
            }
            else
                indegree[v]=i;
        }
        int icf=isCloseFigure(edges,bl);
        if(bl!=-1 && icf==-1)
        {
            res[0]=edges[bl][0];
            res[1]=edges[bl][1];
        }
        else if(bl!=-1 && icf!=-1)
        {
            res[0]=edges[pa][0];
            res[1]=edges[pa][1];
        }
        else
        {
            res[0]=edges[icf][0];
            res[1]=edges[icf][1];
        }
        return res;
    }
}