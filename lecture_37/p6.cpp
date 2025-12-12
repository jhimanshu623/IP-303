class Solution {
public:
    void dfs(vector<vector<int>>& arr,int r,int c)
    {
        int n=arr.size();
        int m=arr[0].size();
        arr[r][c]=0;
        if(c+1<m && arr[r][c+1]==1)
            dfs(arr,r,c+1);
        if(r+1<n && arr[r+1][c]==1)
            dfs(arr,r+1,c);
        if(c-1>=0 && arr[r][c-1]==1)
            dfs(arr,r,c-1);
        if(r-1>=0 && arr[r-1][c]==1)
            dfs(arr,r-1,c);
        
    }
    int numEnclaves(vector<vector<int>>& arr) {
        for(int j=0;j<arr[0].size();j++)
        {
            if(arr[0][j]==1)
                dfs(arr,0,j);
            if(arr[arr.size()-1][j]==1)
                dfs(arr,arr.size()-1,j);
        }
        for(int i=0;i<arr.size();i++)
        {
            if(arr[i][0]==1)
                dfs(arr,i,0);
            if(arr[i][arr[0].size()-1]==1)
                dfs(arr,i,arr[0].size()-1);
        }
        int count=0;
        for(int i=0;i<arr.size();i++)
        {
            for(int j=0;j<arr[0].size();j++)
            {
                if(arr[i][j]==1)
                    count++;
            }
        }
        return count;
    }
};