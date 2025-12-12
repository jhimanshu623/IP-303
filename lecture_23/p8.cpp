#include<iostream>
#include<vector>

using namespace std;

bool isIdealPermutation(vector<int>& arr) {
    for(int i=0;i<arr.size();i++)
    {
        if(abs(arr[i]-i)>1)
            return false;
    }
    return true;
}

int main(int args,char** argv)
{
    vector<int> arr={0,2,4,3,1,5};
    cout<<boolalpha<<isIdealPermutation(arr);  
    return 0;
}