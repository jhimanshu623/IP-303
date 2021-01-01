int countPS(string str)
{
    int n=str.length();
    int** dp=new int*[n];
    for(int i=0;i<n;i++)
        dp[i]=new int[n]();
        
    
    for(int g=0;g<n;g++)
    {
        for(int i=0;i<n-g;i++)
        {
            int j=i+g;
            if(g==0)
                dp[i][j]=1;
            else
            {
                if(str[i]==str[j])
                {
                    dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;
                }
                else
                {
                    dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                }
            }
        }
    }
    return dp[0][n-1];
}