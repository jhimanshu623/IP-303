#include<queue>
#include<bits/stdc++.h> 
using namespace std;

class Pair
{
    public:
        int wt;
        int cost;
        double cbw;
        Pair(int wt,int cost,double cbw)
        {
            this->wt=wt;
            this->cost=cost;
            this->cbw=cbw;
        }
};

struct comp {
    bool operator()(const Pair* a, const Pair* b) {
        return a->cbw < b->cbw;
    }
};

double fracKnapsack(priority_queue<Pair*, vector<Pair*>, comp> &pq,int cap)
{
    int rc=cap;
    double ans=0.0;
    while(pq.size()>0)
    {
        Pair* rp=pq.top(); pq.pop();
        if(rp->wt <= rc)
        {
            ans+=rp->cost;
            rc-=rp->wt;
        }
        else
        {
            ans+=rp->cbw * rc;
            rc=0;
        }
    }
    return ans;
}


int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        int n,cap;
        cin>>n;
        cin>>cap;
        priority_queue<Pair*, vector<Pair*>, comp> pq;
        for(int i=0;i<n;i++)
        {
            int wt,cost;
            cin>>cost;
            cin>>wt;
            double cbw=cost*1.0/wt;
            pq.push(new Pair(wt,cost,cbw));
        }
        cout << fixed << setprecision(2) << fracKnapsack(pq,cap)<<endl;
    }
	return 0;
}