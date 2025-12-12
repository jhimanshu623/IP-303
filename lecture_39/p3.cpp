#include <iostream>
#include<vector>
#include<queue>
using namespace std;

class Edge
{	
	public:
		int u;
		int v;
		int wt;
		Edge(int u,int v,int wt)
		{
			this->u=u;
			this->v=v;
			this->wt=wt;
		}
		int operator>(const Edge& other)const
		{
			return this->wt > other.wt;
		}
};
priority_queue<Edge,vector<Edge>,greater<Edge>> pq;
vector<int> par(0);
vector<int> ra(0);

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
	if(ra[xl]<ra[yl])
		par[xl]=yl;
	else if(ra[yl]<xl)
		par[yl]=xl;
	else
	{
		par[xl]=yl;
		ra[yl]++;
	}
}
long long int kruskals(int n)
{
	for(int i=0;i<n;i++)
	{
		par.push_back(i);
		ra.push_back(1);
	}
	long long int mst=0;
	while(pq.size()>0)
	{
		Edge re=pq.top();
		pq.pop();
		int xl=find(re.u);
		int yl=find(re.v);
		if(xl!=yl){
            merge(xl,yl);
            mst+=re.wt;
        }
	}
	return mst;
}
int main() {
	int n;
	cin>>n;
    int e;
	cin>>e;
	for(int i=0;i<e;i++)
	{
		int u,v,wt;
		cin>>u;
        cin>>v;
        cin>>wt;
		pq.push(Edge(u,v,wt));
	}
	cout<<kruskals(n+1)<<endl;
	return 0;
}

// 4 5
// 0 1 8
// 1 2 10
// 2 3 12
// 1 3 14
// 0 3 16