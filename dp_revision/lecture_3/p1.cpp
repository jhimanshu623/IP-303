class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int T_i10=0;
        int T_i11=INT_MIN;
        for(int i=0;i<prices.size();i++)
        {
            T_i10=max(T_i10,T_i11+prices[i]);
            T_i11=max(T_i11,-prices[i]);
        }
        return T_i10;
    }
};