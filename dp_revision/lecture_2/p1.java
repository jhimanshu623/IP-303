// O(n2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int ans=0;
        for(int i=0;i<dp.length;i++)
        {
            dp[i]=1;
            for(int j=0;j<i;j++)
            {
                if(nums[i] > nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
