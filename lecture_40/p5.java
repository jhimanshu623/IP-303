class Solution {
    public int maxDistance(int[][] grid) {
        LinkedList<Integer> que=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int ans=-1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                    que.addLast(i*m+j);
            }
        }
        int[][] dir={
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        while(que.size()>0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rp=que.removeFirst();
                int r=rp/m;
                int c=rp%m;
                for(int d=0;d<dir.length;d++)
                {
                    int nr=r+dir[d][0];
                    int nc=c+dir[d][1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==0)
                    {
                        grid[nr][nc]=1;
                        que.addLast(nr*m+nc);
                    }
                }
            }
            ans++;
        }
        return ans==0?-1:ans;
    }
}