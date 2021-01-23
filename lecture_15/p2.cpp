#include<iostream>
#include<vector>
#include<queue>
using namespace std;

void kSorted(vector<int>& arr,int k)
{
    priority_queue<int,vector<int>,greater<int>> pq;
    for(int i=0;i<=k;i++)
        pq.push(arr[i]);
    int i=k+1;
    int j=0;
    while(i<arr.size())
    {
        arr[j]=pq.top();pq.pop();
        pq.push(arr[i]);
        i++;
        j++;
    }
    while(pq.size()>0)
    {
        arr[j]=pq.top();pq.pop();
        j++;
    }
}
int main(int args,char** argv)
{
    vector<int> arr={5,14,2,8,15,25,35,20,40,50,42};
    kSorted(arr,3);
    for(int i:arr)
        cout<<i<<" ";
    return 0;
}