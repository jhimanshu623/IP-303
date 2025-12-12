#include<iostream>
#include<limits>
#include<vector>
using namespace std;

int partitionDisjoint(vector<int>& arr) {
    int ans=0;
    int lmax=numeric_limits<int>::min();
    vector<int> rmin(arr.size(),0);
    rmin[arr.size()-1]=arr[arr.size()-1];
    for(int i=arr.size()-2;i>=0;i--)
        rmin[i]=min(arr[i],rmin[i+1]);
    for(int i=0;i<arr.size()-1;i++)
    {
        lmax=max(lmax,arr[i]);
        if(lmax<=rmin[i+1])
            return i+1;
    }
    return arr.size();
}

int partitionDisjoint2(vector<int>& arr) {
    int cmax=arr[0];
    int nmax=arr[0];
    int ans=0;
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]<cmax){
            ans=i;
            cmax=nmax;
        }
        else
            nmax=max(nmax,arr[i]);   
    }
    return ans+1;
}

int main(int args,char** argv)
{
    vector<int> arr={4,6,8,2,20,10,3,25};
    cout<<partitionDisjoint(arr)<<endl;
    cout<<partitionDisjoint2(arr)<<endl;
    return 0;
}