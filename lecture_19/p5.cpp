#include<iostream>
#include<vector>
using namespace std;

// 12ms
int fib1(int n)
{
    if(n<=1)
        return n;
    return fib1(n-1)+fib1(n-2);
}

// 0ms
int fib2_(int n,vector<int>& strg)
{
    if(n<=1)
        return n;
    if(strg[n]!=0)
        return strg[n];
    int nm1=fib2_(n-1,strg);
    int nm2=fib2_(n-2,strg);
    strg[n]=nm1+nm2;
    return nm1+nm2;
}
int fib2(int n)
{
    vector<int> strg(n+1,0);
    return fib2_(n,strg);
}

// 0ms
int fib3(int n)
{
    int a=0;
    int b=1;
    int count=0;
    while(count!=n)
    {
        int c=a+b;
        a=b;
        b=c;
        count++;
    }
    return a;
}

void mult(vector<vector<int>>& a,vector<vector<int>>& b)
{
    int e00=a[0][0]*b[0][0]+a[0][1]*b[1][0];
    int e01=a[0][0]*b[0][1]+a[0][1]*b[1][1];
    int e10=a[1][0]*b[0][0]+a[1][1]*b[1][0];
    int e11=a[1][0]*b[0][1]+a[1][1]*b[1][1];
    a[0][0]=e00;
    a[0][1]=e01;
    a[1][0]=e10;
    a[1][1]=e11;
}
void power(vector<vector<int>>& a,int n)
{
    vector<vector<int>> ans={
        {1,0},
        {0,1}
    };
    while(n!=1)
    {
        if(n%2!=0)
        {
            mult(ans,a);
            n--;
        }
        mult(a,a);
        n=n/2;
    }
    mult(a,ans);
}
// 0ms
int fib4(int n)
{
    if(n<=1)
        return n;
    vector<vector<int>> a={
        {1,1},
        {1,0}
    };
    power(a,n-1);
    return a[0][0];
}

int main(int args,char** argv)
{
    int n=28;
    cout<<fib1(n)<<endl;
    cout<<fib2(n)<<endl;
    cout<<fib3(n)<<endl;
    cout<<fib4(n)<<endl;
    return 0;
}