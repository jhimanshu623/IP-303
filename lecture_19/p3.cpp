#include<iostream>
#include<vector>
using namespace std;

vector<int> sortedSquares(vector<int>& arr) {
    vector<int> res(arr.size(),0);
    int i=0;
    int j=arr.size()-1;
    int k=arr.size()-1;
    while(i<=j)
    {
        if(abs(arr[i])>abs(arr[j])){
            res[k]=arr[i]*arr[i];
            i++;
        }
        else{
            res[k]=arr[j]*arr[j];
            j--;
        }
        k--;
    } 
    return res;
}

int main(int args,char** argv)
{
    vector<int> arr={-7,-3,2,3,11};
    vector<int> res=sortedSquares(arr);
    for(int i:res)
        cout<<i<<" ";
    return 0;
}