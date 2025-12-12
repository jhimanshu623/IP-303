class Solution {
    int[][] dir={
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public void dfs(int[][] arr,int r,int c,LinkedList<Integer> que)
    {
        arr[r][c]=4;
        que.addLast(r*arr[0].length+c);
        if(c+1<arr[0].length && arr[r][c+1]==1)
            dfs(arr,r,c+1,que);
        if(r+1<arr.length && arr[r+1][c]==1)
            dfs(arr,r+1,c,que);
        if(c-1>=0 && arr[r][c-1]==1)
            dfs(arr,r,c-1,que);
        if(r-1>=0 && arr[r-1][c]==1)
            dfs(arr,r-1,c,que);
    }
    public int shortestBridge(int[][] arr) {
        LinkedList<Integer> que=new LinkedList<>();
        int flag=0;
        int l=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==1){
                    dfs(arr,i,j,que);
                    flag=1;
                    break;
                }
            }
            if(flag==1)
                break;
        }
        while(que.size()>0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rv=que.removeFirst();
                int r=rv/arr[0].length;
                int c=rv%arr[0].length;
                for(int d=0;d<dir.length;d++)
                {
                    int nr=r+dir[d][0];
                    int nc=c+dir[d][1];
                    if(nr>=0 && nc>=0 && nr<arr.length && nc<arr[0].length && arr[nr][nc]!=4){
                        if(arr[nr][nc]==1)
                            return l;
                        arr[nr][nc]=4;
                        que.addLast(nr*arr[0].length+nc);
                    }
                }
            }
            l++;
        }
        return l-1;
    }
}