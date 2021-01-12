#include<iostream>
#include<vector>
#include<climits>
using namespace std;

int msass(vector<int>& arr)
{
    vector<int> peak(arr.size(),0);
    vector<int> dip(arr.size(),0);
    peak[peak.size()-1]=arr[arr.size()-1];
    dip[dip.size()-1]=arr[arr.size()-1];
    for(int i=arr.size()-2;i>=0;i--)
    {
        int mp=INT_MIN;
        int md=INT_MIN;
        for(int j=i+1;j<arr.size();j++)
        {
            if(arr[j]>arr[i])
                mp=max(mp,peak[j]);
            if(arr[j]<arr[i])
                md=max(md,dip[j]);
        }
        mp=(mp==INT_MIN)?0:mp;
        md=(md==INT_MIN)?0:md;
        peak[i]=md+arr[i];
        dip[i]=mp+arr[i];
    }
    return peak[0];
}

int main(int args,char **argv)
{
    vector<int> arr={4, 8, 2, 5, 6, 8} ;
    cout<<msass(arr)<<endl;
    return 0;
}