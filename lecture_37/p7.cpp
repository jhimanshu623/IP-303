class Solution {
public:
    class Pair
    {
        public:
        int r;
        int c;
        int d;
        Pair(int r,int c,int d)
        {
            this->r=r;
            this->c=c;
            this->d=d;            
        }
    };
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n=mat.size();
        int m=mat[0].size();
        queue<Pair> que;
        vector<vector<int>> res(n,vector<int>(m,0));
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                    que.push(Pair(i,j,0));
            }
        }
        while(que.size()>0)
        {
            Pair rp=que.front();
            que.pop();
            int r=rp.r;
            int c=rp.c;
            res[r][c]=rp.d;
            if(c+1<m && mat[r][c+1]==1){
                que.push(Pair(r,c+1,rp.d+1));
                mat[r][c+1]=0;
            }
            if(r+1<n && mat[r+1][c]==1){
                que.push(Pair(r+1,c,rp.d+1));  
                mat[r+1][c]=0;
            }
            if(c-1>=0 && mat[r][c-1]==1){
                que.push(Pair(r,c-1,rp.d+1));
                mat[r][c-1]=0;
            }
            if(r-1>=0 && mat[r-1][c]==1){
                que.push(Pair(r-1,c,rp.d+1));
                mat[r-1][c]=0;
            }
        }
        return res;
    }
};