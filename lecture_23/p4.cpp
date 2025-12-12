#include<iostream>
#include<vector>
#include<queue>
#include<climits>

using namespace std;

class Pair
{
    public:
        int x;
        int li;
        int di;
        Pair(int x,int li,int di)
        {
            this->x=x;
            this->li=li;
            this->di=di;
        }
        bool operator>(const Pair& other)const
        {
            return this->x > other.x;
        }
};
vector<int> smallestRange(vector<vector<int>>& nums) {
    vector<int> res;
    int ans=INT_MAX;
    int sp=0;
    int ep=0;
    int m=INT_MIN;
    priority_queue<Pair,vector<Pair>,greater<Pair>> pq;
    for(int i=0;i<nums.size();i++){
        if(nums[i].size()>0)
        {
            pq.push(Pair(nums[i][0],i,0));
            m=max(m,nums[i][0]);
        }
    }
    while(pq.size()>0)
    {
        Pair rp=pq.top();   pq.pop();
        int len=m-rp.x;
        if(len<ans) 
        {
            sp=rp.x;
            ep=m;
            ans=len;
        }
        int ni=rp.di+1;
        if(ni<nums[rp.li].size())
        {
            pq.push(Pair(nums[rp.li][ni],rp.li,ni));
            m=max(m,nums[rp.li][ni]);
        }
        else
            break;
    }
    res.push_back(sp);
    res.push_back(ep);
    return res;
}

int main(int args,char** argv)
{
    vector<vector<int>> nums={
        {4, 10, 15, 24,26},
        {0, 9, 12, 20},
        {5, 18, 22, 30}
    };
    vector<int> res=smallestRange(nums);
    cout<<res[0]<<" "<<res[1];
    return 0;
}