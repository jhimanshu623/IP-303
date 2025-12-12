#include<iostream>
using namespace std;

class PPair
{
    public:
        int v;
        int av;
        int c;
        PPair(int v,int av,int c)
        {
            this->v=v;
            this->av=av;
            this->c=c;
        }
        bool operator>(const PPair& other)const
        {
            return this->c > other.c;
        }
};

void prims()
{
    priority_queue<PPair,vector<PPair>,greater<PPair>> pq;
    vector<vector<Edge>> mst(graph.size(),vector<Edge>());
    vector<bool> visited(graph.size(),false);
    PPair rp(0,-1,0);
    pq.push(rp);
    while(pq.size()>0)
    {
        PPair rp=pq.top();
        pq.pop();
        if(visited[rp.v]==true)
            continue;
        visited[rp.v]=true;
        if(rp.av!=-1)
        {
            addEdge(mst,rp.v,rp.av,rp.c);
        }
        for(int n=0;n<graph[rp.v].size();n++)
        {
            Edge e=graph[rp.v][n];
            if(visited[e.nbr]==false)
            {
                PPair np(e.nbr,rp.v,e.wt);
                pq.push(np);
            }
        }
    }
    display(mst);
}


int main(int args,char** argv)
{
    return 0;
}