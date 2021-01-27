#include<iostream>
#include<vector>
using namespace std;

vector<int> getModifiedArray(int length, vector<vector<int>> &updates) {
    vector<int> res(length,0);
    for(int i=0;i<updates.size();i++)
    {
        res[updates[i][0]]+=updates[i][2];
        if(updates[i][1]+1 < res.size())
            res[updates[i][1]+1]+=-updates[i][2];
    }
    for(int i=1;i<res.size();i++)
    {
        res[i]+=res[i-1];
    }
    return res;
}

int main(int args,char** argv)
{
    int length=5;
    vector<vector<int>> updates={
        {1,  3,  2},
        {2,  4,  3},
        {0,  2, -2}
    };
    vector<int> res=getModifiedArray(length,updates);
    for(int i:res)
        cout<<i<<" ";
    return 0;
}