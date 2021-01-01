class Solution {
public:
    int countPalindromicSubsequences(string str) {
        int n=str.length();
        int** dp=new int*[n];
        for(int i=0;i<n;i++)
            dp[i]=new int[n]();

        int mod=1000000007;
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
                        int i1=i+1;
                        int j1=j-1;
                        while(i1<j && j1>i)
                        {
                            if(str[i1]!=str[i])
                                i1++;
                            if(str[j1]!=str[i])
                                j1--;
                            if(str[i1]==str[i] && str[j1]==str[i])
                                break;
                        }
                        if(i1==j && j1==i)
                            dp[i][j]=(dp[i+1][j-1]+dp[i+1][j-1]+2)%mod;
                        else if(i1==j1)
                            dp[i][j]=(dp[i+1][j-1]+dp[i+1][j-1]+1)%mod;

                        else
                            dp[i][j]=(dp[i+1][j-1]+dp[i+1][j-1]-dp[i1+1][j1-1])%mod;
                    }
                    else
                    {
                        dp[i][j]=(dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1])%mod;
                    }
                    if(dp[i][j]<0)
                        dp[i][j]+=mod;
                }
            }
        }
        return dp[0][n-1];
    }
};