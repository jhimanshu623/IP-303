class Solution {
public:
    int smallestDivisor(vector<int>& nums, int t) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int mp=-1;
        for(int i:nums)
            mp=max(i,mp);
        int lo=1;
        int hi=mp;
        int ans=0;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            
            int rt=0;
            for(int i:nums)
            {
                rt+=ceil(i/(mid*1.0));
            }
            
            if(rt>t)
                lo=mid+1;
            else
            {
                ans=mid;
                hi=mid-1;
            }
        }
        return ans;
    }
};  