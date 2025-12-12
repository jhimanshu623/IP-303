#include<iostream>
#include<vector>
#include<climits>
#include<unordered_map>
using namespace std;

bool checkAp(vector<int>& arr)
{
    if(arr.size()==0)
        return false;
    else if(arr.size()==1)
        return true;
    int s=INT_MAX;
    int ss=INT_MAX;
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]<s){
            ss=s;
            s=arr[i];
        }
        else if(arr[i]<ss && arr[i]>s)
            ss=arr[i];
    }
    if(ss==INT_MAX)
        ss=s;
    int d=ss-s;
    unordered_map<int,int> map;
    for(int i:arr){
        if(d!=0 && map.count(i)>=1)
            return false;
        map[i]++;
    }
    int a=ss;
    map.erase(s);
    map.erase(ss);
    while(map.size()>0)
    {
        if(!map.count(a+d))
            return false;
        a=a+d;
        map.erase(a);
    }
    return true;
}

int main(int args,char** argv)
{
    vector<int> arr={0, 12, 4, 8};
    cout<<boolalpha<<checkAp(arr)<<endl;
    return 0;
}

// simplified
bool checkIsAP(int arr[], int n)
{
    if(n==0)
        return false;
    else if(n==1)
        return true;
    int s=INT_MAX;
    int ss=INT_MAX;
    unordered_map<int,int> map;
    for(int i=0;i<n;i++)
    {
        if(arr[i]<s){
            ss=s;
            s=arr[i];
        }
        else if(arr[i]<ss)
            ss=arr[i];
        map[arr[i]]++;
    }
    int d=ss-s;
    for(int i:arr){
        if(d!=0 && map.count(i)>=1)    //to handle duplicates
            return false;
    }
    int a=ss;
    map.erase(s);
    map.erase(ss);
    while(map.size()>0)
    {
        if(map.find(a+d) == map.end())
            return false;
        a=a+d;
        map.erase(a);
    }
    return true;
}