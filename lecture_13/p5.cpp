#include<iostream>
#include<vector>
#include<queue>
using namespace std;

class Emp
{   
    public:
    int start;
    int end;
    
    Emp(int start,int end)
    {
        this->start=start;
        this->end=end;
    }
    bool operator>(const Emp& o)const
    {
        if(o.start==this->start)
        {
            return this->end>o.end;
        }
        return this->start > o.start;
    }
};
vector<vector<int>> empFree(vector<vector<vector<int>>>& sch)
{
    vector<vector<int>> res;
    priority_queue<Emp,vector<Emp>,greater<Emp>> pq;
    for(int i=0;i<sch.size();i++)
    {
        for(int j=0;j<sch[i].size();j++)
        {
            pq.push(Emp(sch[i][j][0],sch[i][j][1]));
        }
    }
    int st=-1;
    int ed=-1;
    while(pq.size()>0)
    {
        Emp e=pq.top(); pq.pop();
        if(st==-1 && ed==-1){
            st=e.start;
            ed=e.end;
        }
        else
        {
            if(e.start>ed)
            {
                vector<int> v(2,0);
                v[0]=ed;
                v[1]=e.start;
                res.push_back(v);
            }
            ed=e.end;       
        }
    }
    return res;
}

class Emp2
{   
    public:
    int start;
    int end;
    int ri;
    int ci;
    
    Emp2(int start,int end,int ri,int ci)
    {
        this->start=start;
        this->end=end;
        this->ri=ri;
        this->ci=ci;
    }
    bool operator>(const Emp2& o)const
    {
        if(o.start==this->start)
        {
            return this->end>o.end;
        }
        return this->start > o.start;
    }
};
vector<vector<int>> empFree2(vector<vector<vector<int>>>& sch)
{
    vector<vector<int>> res;
    priority_queue<Emp2,vector<Emp2>,greater<Emp2>> pq;
    for(int i=0;i<sch.size();i++)
    {
        pq.push(Emp2(sch[i][0][0],sch[i][0][1],i,0));
    }
    int st=-1;
    int ed=-1;
    while(pq.size()>0)
    {
        Emp2 e=pq.top(); pq.pop();
        if(st==-1 && ed==-1){
            st=e.start;
            ed=e.end;
        }
        else
        {
            if(e.start>ed)
            {
                vector<int> v(2,0);
                v[0]=ed;
                v[1]=e.start;
                res.push_back(v);
            }
            ed=e.end;       
        }
        if(e.ci+1<sch[e.ri].size())
            pq.push(Emp2(sch[e.ri][e.ci+1][0],sch[e.ri][e.ci+1][1],e.ri,e.ci+1));
    }
    return res;
}



int main(int args,char** argv)
{
    vector<vector<vector<int>>> sch={
        {
            {1,3},
            {6,7}
        },
        {
            {2,4}
        },
        {
            {2,5},
            {9,12}
        }
    };
    vector<vector<int>> res=empFree2(sch);
    for(vector<int> v:res)
    {
        for(int val:v)
        {
            cout<<val<<" ";
        }
        cout<<endl;
    }
    return 0;
}