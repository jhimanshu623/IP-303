class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        vector<vector<int>> dp(text1.length()+1,vector<int>(text2.length()+1,0));
        for(int i=dp.size()-2;i>=0;i--)
        {
            for(int j=dp[0].size()-2;j>=0;j--)
            {
                if(text1[i] == text2[j])
                    dp[i][j]=1+dp[i+1][j+1];
                else
                    dp[i][j]=max(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
};