#include<iostream>
#include<vector>
using namespace std;

// O(n2)

// from right to left
int jump(vector<int>& nums) 
{
    nums[nums.size()-1]=0;
    for(int i=nums.size()-2;i>=0;i--)
    {
        int m=nums.size();
        for(int j=i+1;j<=nums[i]+i && j<nums.size() ;j++)
        {
            m=min(m,nums[j]);
        }
        nums[i]=m+1;
    }    
    return nums[0];
}

// from left ot right
int jump(vector<int>& nums) {
    if(nums.size()==0)
        return 0;
    vector<int> dp(nums.size(),nums.size());
    dp[0]=0;
    for(int i=0;i<nums.size();i++)
    {
        for(int j=1;j<=nums[i] && i+j<nums.size();j++)
        {
            dp[i+j]=min(dp[i+j],dp[i]+1);
        }
    }
    return dp[nums.size()-1];
}

// O(n) solution
// test case -> 2,3,1,1,4
//           -> 0

int jump(vector<int>& nums) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int ans=0;
    int cend=0;
    int cmax=0;
    for(int i=0;i<nums.size();i++)
    {
        if(cend>=nums.size()-1)
            return ans;
        cmax=max(cmax,i+nums[i]);
        if(i==cend){
            ans++;
            cend=cmax;
        }
    }
    return ans;
}