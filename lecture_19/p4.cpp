#include<iostream>
#include<vector>
using namespace std;

int power(int x,int n)
{
    int ans=1;
    while(n!=1)
    {
        if(n%2!=0){
            ans=ans*x;
            n--;
        }
        x=(x*x);
        n=n/2;
    }
    ans=ans*x;
    return ans;
}

int main(int args,char** argv)
{
    int x=2;
    int n=10;
    cout<<power(x,n);
    return 0;
}