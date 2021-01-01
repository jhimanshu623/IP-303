class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int T_i0=0;
        int T_i1=INT_MIN;
        for(int val:prices)
        {
            int temp=T_i0;
            T_i0=max(T_i0,T_i1+val);
            T_i1=max(T_i1,temp-val-fee);
        }
        return T_i0;
    }
};