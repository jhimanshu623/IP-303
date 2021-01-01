// sir code
class Solution {
public:
    int minScoreTriangulation(vector<int>& arr) {
        vector<vector<int>> dp(arr.size(),vector<int>(arr.size(),0));
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        for(int g=2;g<arr.size();g++)
        {
            for(int i=0;i<arr.size()-g;i++)
            {
                int j=i+g;
                
                if(g==2)
                    dp[i][j]=arr[i]*arr[i+1]*arr[i+2];
                else
                {
                    int ans=INT_MAX;
                    for(int k=1;k<g;k++)
                    {
                        int left=dp[i][i+k];
                        int right=dp[i+k][j];
                        ans=min(ans, left+right+arr[i]*arr[i+k]*arr[j]);
                    }   
                    dp[i][j]=ans;
                }
            }
        }
        return dp[0][arr.size()-1];
    }
};

// my code

class Solution {
public:
    int minScoreTriangulation(vector<int>& arr) {
        vector<vector<int>> dp(arr.size(),vector<int>(arr.size(),INT_MAX));
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        for(int g=0;g<arr.size();g++)
        {
            for(int i=0;i<arr.size()-g;i++)
            {
                int j=i+g;
                
                if(g==0 || g==1)
                    dp[i][j]=0;
                
                
                for(int k=1;k<g;k++)
                {
                    int left=dp[i][i+k];
                    int right=dp[i+k][j];
                    dp[i][j]=min(dp[i][j], left+right+arr[i]*arr[i+k]*arr[j]);
                }
            }
        }
        return dp[0][arr.size()-1];
    }
};

