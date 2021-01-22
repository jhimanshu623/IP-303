#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

int kDivisible(vector<int>& arr,int k)
{
    int ans=0;
    unordered_map<int,int> map;
    for(int i:arr)
    {
        int rem=i%k;
        if(rem<0)
            rem+=k;
        map[rem]++;
    }
    for(auto c:map)
    {
        if(c.first==0)
        {
            ans+=((c.second*(c.second-1))/2);
        }
        else if(k%2==0 && k/2==c.first)
        {
            ans+=(c.second*(c.second-1))/2;
        }
        else
        {
            if(map[c.first]!=0 && map[k-c.first]!=0)
                ans+=map[c.first]*map[k-c.first];
        }
        map[c.first]=0;
    }
    return ans;
}

int kDivisible_02(vector<int>& arr,int k)
{
    int ans=0;
    unordered_map<int,int> map;
    for(int i:arr)
    {
        int rem=i%k;
        if(rem<0)
            rem+=k;
        if(rem==0)
            ans+=map[rem];
        else
        {
            ans+=map[k-rem];
        }
        map[rem]++;
    }
    return ans;
}

int main(int args,char **argv)
{
    vector<int> arr={2, 2, 1, 7, 5, 3};
    int k=4;
    cout<<kDivisible(arr,k)<<endl;
    cout<<kDivisible_02(arr,k)<<endl;
    return 0;
}