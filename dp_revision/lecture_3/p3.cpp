class Solution {
public:
    int maxProfit(vector<int>& prices) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int T_i10=0,T_i20=0;
        int T_i11=INT_MIN,T_i21=INT_MIN;
        for(int val:prices)
        {
            T_i20=max(T_i20,T_i21+val);
            T_i21=max(T_i21,T_i10-val);
            T_i10=max(T_i10,T_i11+val);
            T_i11=max(T_i11,-val);
        }
        return T_i20;
    }
};