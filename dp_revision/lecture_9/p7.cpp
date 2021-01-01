int wildCard(string pattern,string str)
{
    int n1=str.length();
    int n2=pattern.length();
    vector<vector<bool>> dp(n1+1,vector<bool>(n2+1,false));
    dp[0][0]=true;
    for(int i=0;i<=n1;i++)
    {
        for(int j=1;j<=n2;j++)
        {
            if(i==0)
            {
                dp[i][j]=(pattern[j-1]=='*')?dp[i][j-1]:false;
            }
            else if(str[i-1] == pattern[j-1])
                dp[i][j]=dp[i-1][j-1];
            else
            {
                if(pattern[j-1]=='?')
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(pattern[j-1]=='*')
                {
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
                else
                {
                    dp[i][j]=false;
                }
            }
        }
    }
    return dp[n1][n2];
}