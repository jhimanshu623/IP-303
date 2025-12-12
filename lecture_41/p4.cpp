class Solution {
public:
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    void wallsAndGates(vector<vector<int>> &rooms) {
        if(rooms.size()==0)
            return;
        queue<int> que;
        int n=rooms.size();
        int m=rooms[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(rooms[i][j]==0)
                    que.push(i*m+j);
            }
        }
        int dir[4][2]={
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        int l=0;
        while(que.size()>0)
        {
            int size=que.size();
            while(size-->0)
            {
                int rp=que.front();
                que.pop();
                int r=rp/m;
                int c=rp%m;
                rooms[r][c]=l;
                
                for(int d=0;d<4;d++)
                {
                    int nr=r+dir[d][0];
                    int nc=c+dir[d][1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && rooms[nr][nc]==INT_MAX)
                    {
                        rooms[nr][nc]=0;
                        que.push(nr*m+nc);
                    }
                }
            }
            l++;
        }
    }
};

// more efficient and simple

class Solution {
public:
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    void wallsAndGates(vector<vector<int>> &rooms) {
        if(rooms.size()==0)
            return;
        queue<int> que;
        int n=rooms.size();
        int m=rooms[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(rooms[i][j]==0)
                    que.push(i*m+j);
            }
        }
        int dir[4][2]={
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        while(que.size()>0)
        {
            int rp=que.front();
            que.pop();
            int r=rp/m;
            int c=rp%m;
            for(int d=0;d<4;d++)
            {
                int nr=r+dir[d][0];
                int nc=c+dir[d][1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && rooms[nr][nc]==INT_MAX)
                {
                    rooms[nr][nc]=rooms[r][c]+1;
                    que.push(nr*m+nc);
                }
            }
        }      
    }
};