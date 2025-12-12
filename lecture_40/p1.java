class Solution {
    int[] par;
    int[] rank;
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
    public int[] findRedundantConnection(int[][] edges) {
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
            int x=edges[i][0];
            int y=edges[i][1];
            int xl=find(x);
            int yl=find(y);
            if(xl==yl)
            {
                res[0]=x;
                res[1]=y;
                return res;
            }
            else
                merge(xl,yl);
        }
        return res;
    }
}