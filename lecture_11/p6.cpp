#include<iostream>
#include<vector>
#include<queue>
using namespace std;

// did not worked

class Pair
{
    public:
        int vi;
        int vj;
        int i;
        int j;
        Pair(int vi,int vj,int i,int j)
        {
            this->vi=vi;
            this->vj=vj;
            this->i=i;
            this->j=j;
        }
        bool operator>(const Pair& other)const
        {
            double t=(this->vi*1.0)/this->vj;
            double o=(other.vi*1.0)/other.vj;
            return t>o;
        }
};
vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
    priority_queue<Pair,vector<Pair>,greater<Pair>> pq;
    int j=arr.size()-1;
    for(int i=0;i<arr.size();i++)
        pq.push(Pair(arr[i],arr[j],i,j));
    int count=0;
    while(pq.size()>0)
    {
        Pair p=pq.top(); pq.pop();
        count++;
        if(count==k)
            return vector<int>{p.vi,p.vj};
        if(p.j-1>0)
            pq.push(Pair(arr[p.i],arr[p.j-1],p.i,p.j-1));
    }
    return vector<int>{};
}

int main(int args,char** argv)
{
    vector<int> arr={1,13,17,59};
    int k=6;
    vector<int> res=kthSmallestPrimeFraction(arr,k);
    cout<<res[0]<<","<<res[1]<<endl;
    return 0;
}