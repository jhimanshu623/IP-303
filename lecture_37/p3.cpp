class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int time=0;
        queue<int> que;
        int n=grid.size();
        int m=grid[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                    que.push(i*m+j);
            }
        }
        while(que.size()>0)
        {
            int size=que.size();
            while(size-->0)
            {
                int p=que.front();que.pop();
                int r=p/m;
                int c=p%m;
                grid[r][c]=0;
                if(c+1<m && grid[r][c+1]==1){
                    int np=r*m+c+1;
                    que.push(np);
                    grid[np/m][np%m]=0;
                }
                if(r+1<n && grid[r+1][c]==1){
                    int np=(r+1)*m+c;
                    que.push(np);
                    grid[np/m][np%m]=0;
                }
                if(c-1>=0 && grid[r][c-1]==1){
                    int np=r*m+c-1;
                    que.push(np);
                    grid[np/m][np%m]=0;
                }
                if(r-1>=0 && grid[r-1][c]==1){
                    int np=(r-1)*m+c;
                    que.push(np);
                    grid[np/m][np%m]=0;
                }
            }
            time++;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return time==0?time:time-1;
    }
};


class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int time=0;
        queue<int> que;
        int n=grid.size();
        int m=grid[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                    que.push(i*m+j);
            }
        }
        while(que.size()>0)
        {
            int size=que.size();
            while(size-->0)
            {
                int p=que.front();que.pop();
                int r=p/m;
                int c=p%m;
                grid[r][c]=0;
                if(c+1<m && grid[r][c+1]==1){
                    int np=r*m+c+1;
                    que.push(np);
                    grid[np/m][np%m]=0;
                }
                if(r+1<n && grid[r+1][c]==1){
                    int np=(r+1)*m+c;
                    que.push(np);
                    grid[np/m][np%m]=0;
                }
                if(c-1>=0 && grid[r][c-1]==1){
                    int np=r*m+c-1;
                    que.push(np);
                    grid[np/m][np%m]=0;
                }
                if(r-1>=0 && grid[r-1][c]==1){
                    int np=(r-1)*m+c;
                    que.push(np);
                    grid[np/m][np%m]=0;
                }
            }
            if(que.size()!=0)
                time++;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return time;
    }
};