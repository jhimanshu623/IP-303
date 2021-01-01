class Solution {
public:
    int maxProfit(vector<int>& prices) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int T_i0=0;
        int T_i1=INT_MIN;
        int T_im10=0;
        for(int val:prices)
        {
            int temp=T_i0;
            T_i0=max(T_i0,T_i1+val);
            T_i1=max(T_i1,T_im10-val);
            T_im10=temp;
        }
        return T_i0;
    }
};