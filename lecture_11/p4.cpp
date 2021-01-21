#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

int morningAssembly(vector<int>& arr)
{
    int ans=0;
    unordered_map<int,int> map;
    for(int i=0;i<arr.size();i++)
    {
        if(map.count(arr[i]-1))
            map[arr[i]]=map[arr[i]-1]+1;
        else
            map[arr[i]]=1;
        ans=max(ans,map[arr[i]]);
    }
    return (arr.size()-ans);
}

int main(int args,char** argv)
{
    vector<int> arr={1,8,3,4,2,9,5,7,6};
    cout<<morningAssembly(arr);
    return 0;
}