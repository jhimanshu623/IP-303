#include<iostream>
#include<vector>
using namespace std;

int maxProfit(vector<int>& prices, int fee) {
    if(prices.size()==0)
        return 0;
    int b=-prices[0];
    int s=0;
    for(int i=1;i<prices.size();i++)
    {
        int nb=max(b,s-prices[i]);
        int ns=max(s,b+prices[i]-fee);
        b=nb;
        s=ns;
    }
    return s;
}

int main(int args,char** argv)
{
    vector<int> prices={1, 3, 2, 8, 4, 9};
    int fee=2;
    cout<<maxProfit(prices,fee)<<endl;
    return 0;
}