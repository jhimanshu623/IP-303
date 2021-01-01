#include<iostream>
#include<vector>
using namespace std;

// O(n)
int climbStairs(int n)
{
    int strg[n+1]={0};
    strg[n]=1;
    for(int i=n-1;i>=0;i--)
    {
        strg[i]=strg[i+1];
        strg[i]+=(i+2>n)?0:strg[i+2];
    }
    return strg[0];
}

// O(n)
// finding (n+2) fib. number -> 1 based
int climbStairs_02(int n)
{
    int a=0;
    int b=1;
    for(int i=1;i<=n;i++)
    {
        int c=a+b;
        a=b;
        b=c;
    }
    return a;
}

void mult(vector<vector<int>>& a,vector<vector<int>>& b)
{
    vector<vector<int>> c(a.size(),vector<int>(a[0].size(),0));
    for(int i=0;i<a.size();i++)
    {
        for(int j=0;j<a.size();j++)
        {
            for(int k=0;k<a[0].size();k++)
            {
                c[i][j]+=a[i][k]*b[k][j];   
            }
        }
    }
    a=c;
}

void power(vector<vector<int>>& arr,vector<vector<int>>& iden,int n)
{
    if(n==0 || n==1)
        return;
    power(arr,iden,n/2);
    mult(arr,arr);
    if(n%2!=0)
        mult(arr,iden);
}


// O(log(n))

int climbStairs_03(int n)
{
    if(n==0 || n==1)
        return 1;
    vector<vector<int>> arr={
        {1,1},
        {1,0}
    };
    vector<vector<int>> iden={
        {1,1},
        {1,0}
    };
    power(arr,iden,n);
    return arr[0][0];  // (n+1)th fib number -> 0based
}

int main(int args,char** argv)
{
    cout<<climbStairs(4)<<endl;
    cout<<climbStairs_02(4)<<endl;
    cout<<climbStairs_03(4)<<endl;
    return 0;
}