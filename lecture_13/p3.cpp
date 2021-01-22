#include<iostream>
using namespace std;

int bulbSwitch(int n) {
    int ans=0;
    for(int i=1;i*i<=n;i++)
        ans++;
    return ans;
}

int main(int args,char **argv)
{
    int n=40;
    cout<<bulbSwitch(n)<<endl;
    return 0;
}