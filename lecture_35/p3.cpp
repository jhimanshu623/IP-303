#include<iostream>
using namespace std;

int numBusesToDestination(vector<vector<int>>& routes, int s, int t) {
    int maxStop=-1;
    for(int i=0;i<routes.size();i++)
    {
        for(int j=0;j<routes[i].size();j++)
            maxStop=max(maxStop,routes[i][j]);
    }
    vector<vector<int>> map(maxStop+1,vector<int>());
    for(int i=0;i<routes.size();i++)
    {
        for(int j=0;j<routes[i].size();j++)
        {
            map[routes[i][j]].push_back(i);
        }
    }
    vector<bool> bus_stop(map.size(),false);
    vector<bool> bus_no(routes.size(),false);
    queue<pair<int,int>> que;
    que.push({s,0});
    while(que.size()>0)
    {
        pair<int,int> rp=que.front();
        que.pop();
        if(rp.first==t)
            return rp.second;
        if(bus_stop[rp.first]==true)
            continue;
        bus_stop[rp.first]=true;
        for(int i=0;i<map[rp.first].size();i++)
        {
            int bn=map[rp.first][i];
            if(bus_no[bn]==false)
            {
                bus_no[bn]=true;
                for(int j=0;j<routes[bn].size();j++)
                {
                    int sn=routes[bn][j];
                    if(bus_stop[sn]==false)
                    {
                        que.push({sn,rp.second+1});
                    }
                }
            }
        }
    }
    return -1;
}

int numBusesToDestination(vector<vector<int>>& routes, int s, int t) {
    int maxStop=-1;
    for(int i=0;i<routes.size();i++)
    {
        for(int j=0;j<routes[i].size();j++)
            maxStop=max(maxStop,routes[i][j]);
    }
    vector<vector<int>> map(maxStop+1,vector<int>());
    for(int i=0;i<routes.size();i++)
    {
        for(int j=0;j<routes[i].size();j++)
        {
            map[routes[i][j]].push_back(i);
        }
    }
    vector<bool> bus_stop(map.size(),false);
    vector<bool> bus_no(routes.size(),false);
    queue<int> que;
    int count=0;
    que.push(s);
    while(que.size()>0)
    {
        int size=que.size();
        while(size-->0)
        {
            int rp=que.front();
            que.pop();
            if(rp==t)
                return count;
            for(int i=0;i<map[rp].size();i++)
            {
                int bn=map[rp][i];
                if(bus_no[bn]==false)
                {
                    bus_no[bn]=true;
                    for(int j=0;j<routes[bn].size();j++)
                    {
                        int sn=routes[bn][j];
                        if(bus_stop[sn]==false)
                        {
                            bus_stop[sn]=true;
                            que.push(sn);
                        }
                    }
                }
            }
        }
        count++;
    }
    return -1;
}
int main(int args,char** argv)
{
    return 0;
}