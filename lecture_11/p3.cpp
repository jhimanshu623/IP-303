#include<iostream>
#include<vector>
#include<climits>
#include<algorithm>
#include<unordered_map>
using namespace std;

class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        sort(arr.begin(),arr.end());
        unordered_map<double,int> map;
        for(int i:arr)
            map[i*1.0]++;
        for(int i=0;i<arr.size();i++)
        {
            if(map[arr[i]*1.0]==0)
                continue;
            double p;
            if(arr[i]<0)
                p=(arr[i]*1.0)/2;
            else
                p=arr[i]*2.0;
            if(map[p]==0){
                return false;
            }
            map[arr[i]*1.0]--;
            map[p]--;
        }
        return true;
    }
};

// same code
bool canReorderDoubled(vector<int>& arr) {
    sort(arr.begin(),arr.end());
    unordered_map<double,int> map;
    for(int i:arr)
        map[i*1.0]++;
    for(int i=0;i<arr.size();i++)
    {
        if(map.count(arr[i*1.0])==0)
            continue;
        double p;
        if(arr[i]<0)
            p=(arr[i]*1.0)/2;
        else
            p=arr[i]*2.0;
        if(map.count(p)==0)
            return false;
        map[arr[i*1.0]]--;
        map[p]--;
        if(map[arr[i*1.0]]==0)
            map.erase(arr[i*1.0]);
        if(map[p]==0)
            map.erase(p);
    }
    if(map.size()>0)
        return false;
    return true;
}


int main(int args,char** argv)
{
    vector<int> arr={-4,2,-2,4};
    cout<<canReorderDoubled(arr);
    return 0;
}