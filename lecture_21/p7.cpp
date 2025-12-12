#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int longestOnes(vector<int>& arr, int k) {
    int ans=0;
    queue<int> idx_que;
    int j=0;
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]==0)
        {
            idx_que.push(i);
            if(idx_que.size()>k){
                j=idx_que.front()+1; 
                idx_que.pop();
            }
        }
        ans=max(ans,i-j+1);
    }
    return ans;
}
int main(int args,char** argv)
{
    vector<int> arr={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
    int k=3;
    cout<<longestOnes(arr,k);
    return 0;
}