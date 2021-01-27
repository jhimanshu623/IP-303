#include<iostream>
#include<vector>
using namespace std;

void segregate012(vector<int>& arr)
{
    int i=0;
    int j=0;
    int k=arr.size()-1;
    while(j<=k)
    {
        if(arr[j]==0)
        {
            swap(arr[i],arr[j]);
            i++;
            j++;
        }
        else if(arr[j]==2)
        {
            swap(arr[j],arr[k]);
            k--;
        }
        else
            j++;
    }
}
int main(int args,char** argv)
{
    vector<int> arr={2,1,0,0,2,1};
    segregate012(arr);
    for(int i:arr)
        cout<<i<<" ";
    return 0;
}