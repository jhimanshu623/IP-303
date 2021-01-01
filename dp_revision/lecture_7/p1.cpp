class Solution {
public:
    int solve(vector<vector<int>>& grid ,int r1 ,int c1 ,int r2 ,vector<vector<vector<int>>>& dp)
    {
        int c2=r1+c1-r2;
        if(r1>=grid.size() || r2>=grid.size() || c1>=grid[0].size() || c2>=grid[0].size() || grid[r1][c1]==-1 || grid[r2][c2]==-1)
            return INT_MIN;
        
        if(r1 == grid.size()-1 && c1 == grid[0].size()-1)
            return grid[r1][c1];
        
        if(dp[r1][c1][r2]!=-1)
            return dp[r1][c1][r2];
        
        int ans=0;
        
        ans+=grid[r1][c1];
        if(r1!=r2 && c1!=c2)
            ans+=grid[r2][c2];
            
        int temp1=solve(grid ,r1+1 ,c1 ,r2+1 ,dp);
        int temp2=solve(grid ,r1 ,c1+1 ,r2 ,dp);
        int temp3=solve(grid ,r1+1 ,c1 ,r2 ,dp);
        int temp4=solve(grid ,r1 ,c1+1 ,r2+1 ,dp);
        
        if(temp1==INT_MIN && temp2==INT_MIN && temp3==INT_MIN && temp4==INT_MIN){
            dp[r1][c1][r2]=INT_MIN;
            return INT_MIN;
        }
        ans+=max(temp1 ,max(temp2 ,max(temp3 ,temp4)));
        dp[r1][c1][r2]=ans;
        return ans;
    }
    int cherryPickup(vector<vector<int>>& grid) {
        vector<vector<vector<int>>> dp(grid.size(),
                  vector<vector<int>>(grid.size(),
                  vector<int>(grid.size(),-1)));
        int ans=solve(grid,0,0,0,dp);
        return (ans==INT_MIN)?0:ans;
    }
};

// tabulation

class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        
        int n=grid.size();
            
        vector<vector<vector<int>>> dp(n,
                  vector<vector<int>>(n,
                  vector<int>(n,INT_MIN)));
        
        for(int r1=n-1 ;r1>=0 ;r1--)
        {
            for(int c1=n-1 ;c1>=0 ;c1--)
            {
                for(int r2=n-1 ;r2>=0 ;r2--)
                {
                    int c2=r1+c1-r2;
                    if(c2>=n || c2<0){
                        continue;
                    }
                    if(r1 == n-1 && c1 == n-1){
                        dp[r1][c1][r2]=grid[r1][c1];
                        continue;
                    }
                    else if(grid[r1][c1]==-1 || grid[r2][c2]==-1){
                        dp[r1][c1][r2]=INT_MIN;
                        continue;
                    }
                    int ans=0;
                    ans+=grid[r1][c1];
                    if(r1!=r2 && c1!=c2)
                        ans+=grid[r2][c2];
                    int temp1=INT_MIN;
                    int temp2=INT_MIN;
                    int temp3=INT_MIN;
                    int temp4=INT_MIN;
                    
                    
                    if(r1!=n-1 && r2!=n-1)
                        temp1=dp[r1+1][c1][r2+1];
                    
                    
                    if(c1!=n-1)
                        temp2=dp[r1][c1+1][r2];
                    
                    if(r1!=n-1)
                        temp3=dp[r1+1][c1][r2];
                    
                    if(c1!=n-1 && r2!=n-1)
                        temp4=dp[r1][c1+1][r2+1];
                    
                    
                    if(temp1==INT_MIN && temp2==INT_MIN && temp3==INT_MIN && temp4==INT_MIN)
                        dp[r1][c1][r2]=INT_MIN;
                    else
                    {
                        ans+=max(temp1 ,max(temp2 ,max(temp3 ,temp4)));
                        dp[r1][c1][r2]=ans;   
                    }
                }
            }
        }
        return dp[0][0][0]==INT_MIN?0:dp[0][0][0];
    }
};