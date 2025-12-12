#include<iostream>
#include<vector>

using namespace std;

int firstMissingPositive(vector<int>& arr) {
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]==0 || arr[i]>arr.size() || arr[i]<0)
            arr[i]=arr.size()+1;
    }
    for(int i=0;i<arr.size();i++)
    {
        if(abs(arr[i])<=arr.size())
        {
            int idx=abs(arr[i])-1;
            arr[idx]=-abs(arr[idx]); // because if number is already marked negative, then it should not be marked positve thats why abs is taken
        }
    }
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]>0)
            return i+1;
    }
    return arr.size()+1;
}

int main(int args,char** argv)
{
    vector<int> arr={2,-3,0,3,1,8,-10};
    cout<<firstMissingPositive(arr);   
    return 0;
}