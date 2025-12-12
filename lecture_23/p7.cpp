#include<iostream>
#include<vector>

using namespace std;

int maxSumTwoNoOverlap(vector<int>& arr, int l, int m) {
    vector<int> ps(arr.size(),0);
    vector<int> lsize(arr.size()-l+1,0);
    vector<int> msize(arr.size()-m+1,0);
    vector<int> lmax(arr.size()-l+1,0);
    vector<int> mmax(arr.size()-m+1,0);
    ps[0]=arr[0];
    for(int i=1;i<ps.size();i++)
        ps[i]=arr[i]+ps[i-1];
    for(int i=0;i<lsize.size();i++){
        if(i==0){
            lsize[i]=ps[i+l-1];   
            lmax[i]=lsize[i];
        } 
        else{
            lsize[i]=ps[i+l-1]-ps[i-1];
            lmax[i]=max(lmax[i-1],lsize[i]);
        }
    }
    for(int i=0;i<msize.size();i++){
        if(i==0){
            msize[i]=ps[i+m-1];
            mmax[i]=msize[i];
        } 
        else{
            msize[i]=ps[i+m-1]-ps[i-1];
            mmax[i]=max(mmax[i-1],msize[i]);
        }
    }
    int ans=0;
    int i=0;
    int j=m;
    while(j<lsize.size())
    {
        ans=max(ans, mmax[i]+lsize[j]);
        i++;
        j++;
    }
    i=0;
    j=l;
    while(j<msize.size())
    {
        ans=max(ans, lmax[i]+msize[j]);
        i++;
        j++;
    }
    return ans;
}

int main(int args,char** argv)
{
    vector<int> arr={0,6,5,2,2,5,1,9,4};
    int l=2;
    int m=3;
    cout<<maxSumTwoNoOverlap(arr,l,m);   
    return 0;
}