#include<iostream>
#include<vector>
using namespace std;

void segragate01(vector<int>& arr)
{
    int i=0;
    int j=0;
    while(j<arr.size())
    {
        if(arr[j]==0)
        {
            swap(arr[i],arr[j]);
            i++;
            j++;
        }
        else
            j++;
    }
}
int main(int args,char** argv)
{
    vector<int> arr={0,1,0,1,0,0,1,1,0};
    segragate01(arr);
    for(int i:arr)
        cout<<i<<" ";
    return 0;
}