#include<iostream>
#include<vector>
#include<unordered_map>
#define ll long long
using namespace std;

int numberOfArithmeticSlices(vector<int>& arr) {
    ll ans=0;
    unordered_map<ll,int> strg[arr.size()];
    for(int i=1;i<arr.size();i++)
    {
        for(int j=i-1;j>=0;j--)
        {
            ll x=(ll)arr[i]-(ll)arr[j];
            if(strg[j].count(x))
            {
                ans+=strg[j][x];
                cout<<strg[j][x]<<" ";
                strg[i][x]+=strg[j][x]+1;
            }
            else
            {
                strg[i][x]+=1;
            }
        }
    }
    return (int)ans;
}

int main(int args,char** argv)
{
    vector<int> arr={1,1,1,1,1};
    cout<<numberOfArithmeticSlices(arr)<<endl;
    return 0;
}