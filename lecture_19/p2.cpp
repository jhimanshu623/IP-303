#include<iostream>
#include<cmath>
using namespace std;

void printPrimeRange(int n,int m)
{
    int rn=ceil(sqrt(n));
    bool arr[rn+1];
    fill_n(arr,rn+1,true);
    arr[0]=false;
    arr[1]=false;
    for(int i=2;i*i<=rn;i++)
    {
        if(arr[i]==true)
        {
            for(int j=2;j*i<=rn;j++)
                arr[i*j]=false;
        }
    }
    bool nm[n-m+1];
    fill_n(nm,n-m+1,true);
    for(int i=2;i<=rn;i++)
    {
        if(arr[i]==true)
        {
            int p=1;
            int j=0;
            while(j<=n-m)
            {
                if(j+m==0 || j+m==1)  // (j+m==0) is not required
                    nm[j]=false;
                if((j+m)%i==0)
                {
                    if(j+m!=i)
                        nm[j]=false;
                    p=i;
                }
                j+=p;
            }
        }
    }
    for(int i=0;i<=n-m;i++)
    {
        if(nm[i]==true)
            cout<<i+m<<" ";
    }
}

int main(int args,char** argv)
{
    int n=50;
    int m=22;
    printPrimeRange(n,m);
    cout<<endl;
    return 0;
}