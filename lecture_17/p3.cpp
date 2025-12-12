#include<iostream>
#include<vector>
using namespace std;

int solve(int length,vector<vector<int>>& queries,int k)
{
    vector<int> res(length,0);
    for(int i=0;i<queries.size();i++)
    {
        res[queries[i][0]]+=1;
        if(queries[i][1]+1 < res.size())
            res[queries[i][1]+1]+=-1;
    }
    vector<int> countk(res.size(),0);
    vector<int> countkp1(res.size(),0);
    int count=0;
    // need to consider res[0] also here
    for(int i=1;i<res.size();i++){
        res[i]+=res[i-1];
        if(res[i]==k)
            count++;
        countk[i]=(res[i]==k)?countk[i-1]+1:countk[i-1];
        countkp1[i]=(res[i]==k+1)?countkp1[i-1]+1:countkp1[i-1];
    }
    int ans=0;
    for(int i=0;i<queries.size();i++)
    {
        int ck;
        int ckp1;
        if(queries[i][0]-1>=0)
        {
            ck=countk[queries[i][1]]-countk[queries[i][0]-1];
            ckp1=countkp1[queries[i][1]]-countkp1[queries[i][0]-1];
        }
        else
        {
            ck=countk[queries[i][1]];
            ckp1=countkp1[queries[i][1]];
        }
        ans=max(ans,count-ck+ckp1);
    }
    return ans;
}

int main(int args,char** argv)
{
    int n=3;
    int k=2;
    vector<vector<int>> queries={
        {2,6},
        {4,9},
        {1,4}
    };
    int length=0;
    for(int i=0;i<queries.size();i++)
    {
        length=max(length,queries[i][1]);
    }
    cout<<solve(length+1,queries,k);
    return 0;
}