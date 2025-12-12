#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int minPlatforms(vector<int>& arr,vector<int>& dept)
{
    int count=0;
    int i=0;
    int j=0;
    int ans=0;
    sort(arr.begin(),arr.end());
    sort(dept.begin(),dept.end());
    while(i<arr.size())
    {
        if(arr[i]<=dept[j])
        {
            count++;
            i++;
        }
        else
        {
            count--;
            j++;
        }
        ans=max(ans,count);
    }
    return ans;
}

int main(int args,char** argv)
{
    vector<int> arr={900,940,950,1100,1500,1800};
    vector<int> dept={910,1200,1120,1130,1900,2000};
    cout<<minPlatforms(arr,dept)<<endl;
    return 0;
}