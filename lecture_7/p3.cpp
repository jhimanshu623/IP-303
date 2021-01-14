#include<iostream>
#include<vector>
using namespace std;

int numberOfArithmeticSlices(vector<int>& arr) {
    int pres=0;
    int cd=arr[1]-arr[0];
    int ans=0;
    for(int i=2;i<arr.size();i++)
    {
        int pd=cd;
        cd=arr[i]-arr[i-1];
        if(cd==pd)
            pres=pres+1;
        else
            pres=0;
        ans+=pres;
    }
    return ans;
}

int numberOfArithmeticSlices_02(vector<int>& arr) 
{
    int strg=0;
    int ans=0;
    for(int i=2;i<arr.size();i++)
    {
        int pd=arr[i-1]-arr[i-2];
        int cd=arr[i]-arr[i-1];
        if(cd==pd)
            strg=strg+1;
        else
            strg=0;
        ans+=strg;
    }
    return ans;
}

int main(int args,char** argv)
{
    vector<int> arr={1,3,5,7,9,15,20,25,27,29};
    cout<<numberOfArithmeticSlices(arr);
    cout<<numberOfArithmeticSlices_02(arr);
    return 0;
}