
// memorization

class Solution {
public:
    int solve(vector<int>& nums,int l,int r,vector<vector<int>>& dp)
    {
        if(l+1 == r)
            return 0;
        if(dp[l+1][r+1]!=-1)
            return dp[l+1][r+1];
        int ans=0;
        for(int i=l+1;i<r;i++)
        {
            int temp1=solve(nums,l,i,dp);
            int temp2=solve(nums,i,r,dp);
            int lv=1;
            int rv=1;
            if(l!=-1)
                lv=nums[l];
            if(r!=nums.size())
                rv=nums[r];
            
            int temp_ans=temp1+temp2+(nums[i] * lv * rv);
            ans=max(ans,temp_ans);
        }
        dp[l+1][r+1]=ans;
        return ans;
    }
    int maxCoins(vector<int>& nums) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        vector<vector<int>> dp(nums.size()+2,vector<int>(nums.size()+2,-1));
        return solve(nums,-1,nums.size(),dp);
    }
};

// tabulation

class Solution {
public:
    int maxCoins(vector<int>& nums) {
        if(nums.size()==0)
            return 0;
        
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        
        vector<int> arr(nums.size()+2);
        arr[0]=1;
        arr[arr.size()-1]=1;
        for(int i=0;i<nums.size();i++)
            arr[i+1]=nums[i];
                
        vector<vector<int>> dp(arr.size(),vector<int>(arr.size(),0));
        for(int g=2;g<arr.size();g++)
        {
            for(int i=0;i<arr.size()-g;i++)
            {
                int j=i+g;
                for(int k=1;k<g;k++)
                {
                    int left=dp[i][i+k];
                    int right=dp[i+k][j];
                    dp[i][j]=max(dp[i][j] ,left + right + arr[i] * arr[i+k] * arr[j]);
                }
            }
        }
        return dp[0][dp[0].size()-1];
    }
};


class Solution {
public:
    int maxCoins(vector<int>& nums) {
        if(nums.size()==0)
            return 0;
        
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        
        vector<int> arr(nums.size()+2);
        arr[0]=1;
        arr[arr.size()-1]=1;
        for(int i=0;i<nums.size();i++)
            arr[i+1]=nums[i];
        
        
        vector<vector<int>> dp(arr.size(),vector<int>(arr.size(),0));
        for(int g=2;g<arr.size();g++)
        {
            for(int i=0;i<arr.size()-g;i++)
            {
                int j=i+g;
                for(int k=1;k<g;k++)
                {
                    int left=dp[i][i+k];
                    int right=dp[i+k][j];
                    dp[i][j]=max(dp[i][j] ,left + right + (i-1>=0?nums[i-1]:1) * nums[i+k-1] * (j-1<nums.size()?nums[j-1]:1));
                }
            }
        }
        return dp[0][dp[0].size()-1];
    }
};