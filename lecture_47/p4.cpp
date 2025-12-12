class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int mp=-1;
        for(int i:piles)
            mp=max(i,mp);
        int lo=1;
        int hi=mp;
        int ans=0;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            
            int rh=0;7827849856

            for(int i:piles)
            {
                rh+=ceil(i/(mid*1.0));
            }
            
            if(rh>h)
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