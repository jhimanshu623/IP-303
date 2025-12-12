class Solution {
    int count=0;
    int val=-1;
    int size=0;
    boolean[] vis;
    HashSet<Integer> infected=new HashSet<>();
    public void dfs(int[][] g,int i)
    {
        vis[i]=true;
        size++;
        if(infected.contains(i)){
            count++;
            val=i;
        }
        for(int n=0;n<g[i].length;n++)
        {
            if(n!=i && g[i][n]==1 && vis[n]==false)
                dfs(g,n);
        }
    }
    public int minMalwareSpread(int[][] g, int[] initial) {
        vis=new boolean[g.length];
        for(int i=0;i<initial.length;i++)
            infected.add(initial[i]);
        int ans=-1;
        int asize=0;
        for(int i=0;i<g.length;i++)
        {
            if(vis[i]==false)
            {
                count=0;
                val=-1;
                size=0;
                dfs(g,i);
                if(count==1 && size>=asize)
                {
                    if(ans==-1 || size>asize)
                        ans=val;
                    else
                        ans=Math.min(ans,val);
                    asize=size;
                }
            }
        }
        if(ans==-1)
        {
            for(int v:infected){
                if(ans==-1)
                    ans=v;
                else
                    ans=Math.min(ans,v);
            }
        }
        return ans;
    }
}