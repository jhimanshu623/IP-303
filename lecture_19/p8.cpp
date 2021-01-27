#include<iostream>
#include<vector>
using namespace std;

vector<int> sortArrayByParity(vector<int>& arr) {
    int i=0;
    int j=0;
    while(j<arr.size())
    {
        if(arr[j]%2==0)
        {
            swap(arr[i],arr[j]);
            i++;
            j++;
        }
        else
        {
            j++;
        }
    }
    return arr;
}

int main(int args,char** argv)
{
    vector<int> arr={3,1,2,4};
    sortArrayByParity(arr);
    for(int i:arr)
        cout<<i<<" ";
    return 0;
}