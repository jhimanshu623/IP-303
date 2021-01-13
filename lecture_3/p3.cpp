#include<iostream>
#include<vector>
using namespace std;

int maxProfit(vector<int>& prices) {
    if(prices.size()==0)
        return 0;
    int b=-prices[0];
    int s[prices.size()];
    s[0]=0;
    for(int i=1;i<prices.size();i++)
    {
        s[i]=max(s[i-1],b+prices[i]);
        if(i==1)
            b=max(b,-prices[i]);
        else
            b=max(b,s[i-2]-prices[i]);
    }
    return s[prices.size()-1];
}

int main(int args,char** argv)
{
    vector<int> prices={2,1,4,5,2,9,7};
    cout<<maxProfit(prices)<<endl;
    return 0;
}