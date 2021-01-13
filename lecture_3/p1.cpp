#include<iostream>
#include<vector>
#include<climits>
using namespace std;

int maxProfit(int k, vector<int>& prices) {
    if(prices.size()==0)
        return 0;
    if(k>=prices.size())
    {
        int profit=0;
        for(int i=1;i<prices.size();i++)
        {
            if(prices[i]>prices[i-1])
                profit+=prices[i]-prices[i-1];
        }
        return profit;
    }
    vector<int> bs(k+1,INT_MIN);
    vector<int> ss(k+1,0);
    for(int i=0;i<prices.size();i++)
    {
        for(int j=1;j<=k;j++)
        {
            bs[j]=max(bs[j],ss[j-1]-prices[i]);
            ss[j]=max(ss[j],bs[j]+prices[i]);
        }
    }
    return ss[k];
} 

int main(int args,char** argv)
{
    vector<int> prices={1, 3, 2, 8, 4, 9};
    int k=2;
    cout<<maxProfit(prices,fee)<<endl;
    return 0;
}