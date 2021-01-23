class Solution {
    class Pair implements Comparable<Pair>
    {
        int r;
        int c;
        int v;
        Pair(int r,int c,int v)
        {
            this.r=r;
            this.c=c;
            this.v=v;
        }
        public int compareTo(Pair o)
        {
            return this.v-o.v;
        }
    }
    int[][] dir={
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public int trapRainWater(int[][] heightMap) {
        int n=heightMap.length;
        int m=heightMap[0].length;
        boolean[][] vis=new boolean[n][m];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int j=0;j<m;j++)
        {
            pq.add(new Pair(0,j,heightMap[0][j]));
            pq.add(new Pair(n-1,j,heightMap[n-1][j]));
            vis[0][j]=true;
            vis[n-1][j]=true;
        }
        for(int i=1;i<n-1;i++)
        {
            pq.add(new Pair(i,0,heightMap[i][0]));
            pq.add(new Pair(i,m-1,heightMap[i][m-1]));
            vis[i][0]=true;
            vis[i][m-1]=true;
        }
        int ans=0;
        while(pq.size()>0)
        {
            Pair rp=pq.poll();
            for(int d=0;d<4;d++)
            {
                int nr=rp.r+dir[d][0];
                int nc=rp.c+dir[d][1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==false)
                {
                    if(heightMap[nr][nc]>rp.v)
                        pq.add(new Pair(nr,nc,heightMap[nr][nc]));
                    else
                    {
                        ans+=rp.v-heightMap[nr][nc];
                        pq.add(new Pair(nr,nc,rp.v));
                    }
                    vis[nr][nc]=true;
                }
            }
        }
        return ans;
    }
}