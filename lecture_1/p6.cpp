#include<iostream>
#include<vector>
using namespace std;

// O(n2)
int lis(vector<int>& arr)
{
    int strg[arr.size()];
    int ans=0;
    for(int i=0;i<arr.size();i++)
    {
        int m=0;
        for(int j=i-1;j>=0;j--)
        {
            if(arr[i]>arr[j])
                m=max(m,strg[j]);
        }
        strg[i]=m+1;
        if(strg[i]>ans)
            ans=strg[i];
    }
    return ans;
}

int main(int args,char** argv)
{
    vector<int> arr={10,3,13,7,11,12,15,18,4};
    cout<<lis(arr)<<endl;
    return 0;
}