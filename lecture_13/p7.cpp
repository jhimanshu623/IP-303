#include<iostream>
using namespace std;

long long digitMul(int n)
{
    if(n==1)
        return 1;
    int div=9;
    long long mult=1;
    long long ans=0;
    while(n>1 && div>1)
    {
        if(n%div==0)
        {
            n=n/div;
            ans+=mult*div;
            mult*=10;
        }
        else
            div--;
    }
    if(n>1)
        return -1;
    return ans;
}
int main(int args,char** argv)
{
    int n=100;
    cout<<digitMul(n)<<endl;
    return 0;
}