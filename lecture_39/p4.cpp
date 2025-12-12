#include <iostream>
#include<vector>
#include<queue>

using namespace std;

class Job
{
    public:
    int d;
    int p;
    Job(int d,int p)
    {
        this->d=d;
        this->p=p;
    }   
    int operator<(const Job& other)const
	{
		return this->p < other.p;
	}
};
priority_queue<Job> pq;
void jobSequencing(int md)
{
    vector<int> arr(md,0);
    int p=0;
    int noj=0;
    while(pq.size()>0)
    {
        Job rj=pq.top();
        pq.pop();
        int i=rj.d-1;
        while(arr[i]!=0)
            i--;
        if(i>=0)
        {
            noj++;
            p+=rj.p;
            arr[i]=1;
        }
    }
    cout<<noj<<" "<<p<<endl;
}

// using dsu
vector<int> par;
int find(int x)
{
    if(par[x]==x)
        return x;
    int px=find(par[x]);
    par[x]=px;
    return px;
}
void merge(int xl,int yl)
{
    par[xl]=yl;
}
void jobSequencingDSU(int md)
{
    par.clear();
    for(int i=0;i<=md;i++)
        par.push_back(i);
    int p=0;
    int noj=0;
    while(pq.size()>0)
    {
        Job rj=pq.top();
        pq.pop();
        int x=rj.d;
        int xl=find(x);
        if(xl!=0)
        {
            p+=rj.p;
            noj++;
            int yl=find(xl-1);
            merge(xl,yl);
        }
    }
    cout<<noj<<" "<<p<<endl;
}


int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        int n;
        cin>>n;
        int md=-1;
        for(int i=0;i<n;i++)
    	{
    		int jid,d,p;
    		cin>>jid;
    		cin>>d;
            cin>>p;
    		pq.push(Job(d,p));
    		md=max(md,d);
    	}
    	jobSequencingDSU(md);
    }
	return 0;
}