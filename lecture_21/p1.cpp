#include<iostream>
#include<vector>
#include<limits>
using namespace std;

int numSubarrayBoundedMax2(vector<int>& arr, int l, int r) {
    int j=0;
    int smaller=0;
    int ans=0;
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]>r)
        {
            j=i+1;
            smaller=0;
        }
        else if(arr[i]>=l && arr[i]<=r)
        {
            smaller=i-j+1;
            ans+=smaller;
        }
        else
            ans+=smaller;
    } 
    return ans;
}

// int numSubarrayBoundedMax(vector<int>& arr, int l, int r) {
//     int j=0;
//     int tmp=-1;
//     int ans=0;
//     for(int i=0;i<arr.size();i++)
//     {
//         if(arr[i]>r)
//         {
//             j=i+1;
//             tmp=i;
//         }
//         else if(arr[i]>=l && arr[i]<=r)
//         {
//             ans+=i-j+1;
//             tmp=i;
//         }
//         else
//         {
//             ans+=(i-j)-(i-tmp-1);
//         }
//     } 
//     return ans;
// }


int main(int args,char** argv)
{
    vector<int> arr={1,0,2,5,6,1,2,0,3,7,3,2,4};
    int l=3;
    int r=6;
    cout<<numSubarrayBoundedMax(arr,l,r)<<endl;
    cout<<numSubarrayBoundedMax2(arr,l,r)<<endl;
    return 0;
}