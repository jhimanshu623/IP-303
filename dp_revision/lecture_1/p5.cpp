#include<iostream>
#include<vector>
using namespace std;

int _01knapSack(vector<int>& wt,vector<int>& prices,int cap)
{
    vector<vector<int>> strg(wt.size(),vector<int>(cap+1,0));
    for(int i=0;i<strg.size();i++)
    {
        for(int j=0;j<strg[0].size();j++)
        {
            if(i==0)
            {
                if(j>=wt[0])
                    strg[i][j]=prices[i];
            }
            else
            {
                strg[i][j]=strg[i-1][j];
                if(j>=wt[i])
                {
                    strg[i][j]=max(strg[i][j],prices[i]+strg[i-1][j-wt[i]]);
                }
            }
        }
    }
    return strg[wt.size()-1][cap];
}

int main(int args,char** argv)
{
    // vector<int> wt={4,2,3,1};
    // vector<int> prices={7,4,5,3};
    vector<int> wt={2,5,1,3,4};
    vector<int> prices={15,14,10,45,30};
    int cap=7;
    cout<<_01knapSack(wt,prices,cap);
    return 0;
}   