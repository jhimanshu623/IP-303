#include<iostream>
#include<vector>
using namespace std;

int dominantIndex(vector<int>& arr) {
    int max1=-1;
    int max2=-1;
    int idx=-1;
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]>max1)
        {
            max2=max1;
            max1=arr[i];
            idx=i;
        }
        else if(arr[i]>max2)
        {
            max2=arr[i];
        }
    }
    return max1>=2*max2?idx:-1;
}
int main(int args,char** argv)
{
    vector<int> arr={5,12,3,0,2,4};
    cout<<dominantIndex(arr)<<endl;
    return 0;
}