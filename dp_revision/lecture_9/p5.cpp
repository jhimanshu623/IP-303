#include<iostream>
using namespace std;

int solve(int n,int* x,int* rev,int t,int m)
{
    int* dp=new int[m+1]();
    int j=0;
    int i=x[0];
    while(j<n)
    {
        if(i!=x[j])
        {
            dp[i]=i-1>=0?dp[i-1]:0;
            i++;
            continue;
        }
        dp[i]=rev[j];
        if(i-t-1>=0)
            dp[i]+=dp[i-t-1];
        if(i>=0)
            dp[i]=max(dp[i],dp[i-1]);
        i++;
        j++;
    }
    return dp[x[n-1]];
}

int main(int args,char** argv)
{
    int n=4;
    int* x=new int[n]{6, 9, 12, 14};
    int* rev=new int[n]{5, 6, 3, 7};
    int t=2;
    int m=15;
    cout<<solve(n,x,rev,t,m)<<endl;
    return 0;
}