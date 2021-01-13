#include<iostream>
#include<vector>
using namespace std;

// O(nlogn)

void justGreater(vector<int>& a,int i,int j,int val)
{
    while(i<=j)
    {
        int mid=i+(j-i)/2;
        if(a[mid]<val)
            i=mid+1;
        else
            j=mid-1;
    }
    a[i]=val;
}

int lis(vector<int>& arr)
{
    if(arr.size()==0)
        return 0;
    vector<int> strg(arr.size(),0);
    int length=1;
    strg[0]=arr[0];
    for(int i=1;i<arr.size();i++)
    {
        if(arr[i]<strg[0])
            strg[0]=arr[i];
        else if(arr[i]>strg[length-1])
            strg[length++]=arr[i];
        else
            justGreater(strg,0,length-1,arr[i]);
    }
    return length;
}

int main(int args,char** argv)
{
    vector<int> arr={10,9,2,5,3,7,101,18};
    cout<<lis(arr);
    return 0;
}