#include<iostream>
#include<algorithm>
using namespace std;

void printAllPrime(int n)
{   
    bool arr[n+1];
    fill_n(arr,n+1,true);
    arr[0]=false;
    arr[1]=false;
    for(int i=2;i*i<=n;i++)
    {
        if(arr[i]==true)
        {
            for(int j=2;i*j<=n;j++)
            {
                arr[i*j]=false;
            }
        }
    }
    for(int i=2;i<=n;i++)
    {
        if(arr[i]==true)
            cout<<i<<" ";
    }
}

int main(int args,char** argv)
{
    int n=30;
    printAllPrime(n);
    return 0;
}