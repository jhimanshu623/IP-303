class Solution {
public:
    int InfmaxProfit(vector<int>& prices) {
        int T_i0=0;
        int T_i1=INT_MIN;
        for(int val:prices)
        {
            int temp=T_i0;
            T_i0=max(T_i0,T_i1+val);
            T_i1=max(T_i1,temp-val);
        }
        return T_i0;
    }
    int maxProfit(int k, vector<int>& prices) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        if(k>=prices.size()/2)
            return InfmaxProfit(prices);
        else
        {
            vector<int> T_ik0(k+1,0);
            vector<int> T_ik1(k+1,INT_MIN);
            for(int val:prices)
            {
                for(int j=k;j>=1;j--)
                {
                    T_ik0[j]=max(T_ik0[j],T_ik1[j]+val);
                    T_ik1[j]=max(T_ik1[j],T_ik0[j-1]-val);
                }
            }
            return T_ik0[k];
        }
    }
};