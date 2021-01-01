#include <iostream>
using namespace std;


int editDistance(string s1,string s2,int n1,int n2)
{
    int** dp=new int*[n1+1];
    for(int i=0;i<=n1;i++)
    {
        dp[i]=new int[n2+1]();
    }
    
    for(int i=0;i<=n1;i++)
    {
        for(int j=0;j<=n2;j++)
        {
            if(i==0)
                dp[i][j]=j;
            else if(j==0)
                dp[i][j]=i;
            else
            {
                if(s1[i-1]==s2[j-1])
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+min(dp[i-1][j],min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
    }
    return dp[n1][n2];
}

int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        int n1,n2;
        cin>>n1;
        cin>>n2;
        string s1,s2;
        cin>>s1;
        cin>>s2;
        cout<<editDistance(s1,s2,n1,n2)<<"\n";
    }
	return 0;
}