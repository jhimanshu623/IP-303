#include<iostream>
using namespace std;

class DPair
{
    public: 
        int v;
        int c;
        string p;
        DPair(int v,int c,string p)
        {
            this->v=v;
            this->c=c;
            this->p=p;
        }
        bool operator>(const DPair& other)const
        {
            return this->c > other.c;
        }
};

void djikstra(int s)
{
    priority_queue<DPair,vector<DPair>,greater<DPair>> pq;
    vector<bool> visited(graph.size(),false);
    pq.push(DPair(s,0,to_string(s)));
    while(pq.size()>0)
    {
        DPair rp=pq.top();
        pq.pop();
        if(visited[rp.v]==true)
            continue;
        visited[rp.v]=true;
        cout << rp.v << "@" << rp.c << " via " << rp.p << endl;
        for(int n=0;n<graph[rp.v].size();n++)
        {
            Edge e=graph[rp.v][n];
            if(visited[e.nbr]==false)
            {
                DPair np(e.nbr, rp.c + e.wt, rp.p + to_string(e.nbr));
                pq.push(np);
            }
        }
    }
}

int main(int args,char** argv)
{
    return 0;
}