#include <iostream>
#include<vector>
using namespace std;

int lcsTriplet(int n1,int n2,int n3,string s1,string s2,string s3)
{
    vector<vector<vector<int>>> dp(n1+1,
                                   vector<vector<int>>(n2+1,
                                   vector<int>(n3+1,0)));
    for(int i=n1-1;i>=0;i--)
    {
        for(int j=n2-1;j>=0;j--)
        {
            for(int k=n3-1;k>=0;k--)
            {
                if(s1[i]==s2[j] && s1[i]==s3[k])
                    dp[i][j][k]=1+dp[i+1][j+1][k+1];
                else
                    dp[i][j][k]=max(dp[i+1][j][k] ,max(dp[i][j+1][k] ,dp[i][j][k+1]));
            }
        }
    }
    return dp[0][0][0];
}

int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        int n1,n2,n3;
        cin>>n1>>n2>>n3;
        string s1,s2,s3;
        cin>>s1>>s2>>s3;
        cout<<lcsTriplet(n1,n2,n3,s1,s2,s3)<<"\n";
    }
	return 0;
}