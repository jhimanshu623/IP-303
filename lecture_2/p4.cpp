#include<iostream>
#include<vector>
using namespace std;

int paintFence(int n,int k)
{
    int s=0;
    int d=k;
    for(int i=2;i<=n;i++)
    {
        int ns=d;
        int nd=(s+d)*(k-1);
        s=ns;
        d=nd;
    }
    return s+d;
}

int main(int args,char **argv)
{
    cout<<paintFence(2,2);    
    return 0;
}