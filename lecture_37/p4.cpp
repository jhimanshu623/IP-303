#include <iostream>
#include<vector>
#include<climits>
using namespace std;

bool bellmanFord(int n,vector<vector<int>> &edges,vector<int>& arr)
{
    for(int i=1;i<=n-1;i++)
    {
        for(int e=0;e<edges.size();e++)
        {
            int u=edges[e][0];
            int v=edges[e][1];
            int wt=edges[e][2];
            if(arr[u]==INT_MAX)
                continue;
            if(arr[u]+wt<arr[v])
                arr[v]=Math.min(arr[v],arr[u]+wt);
        }
    }
    for(int e=0;e<edges.size();e++)
    {
        int u=edges[e][0];
        int v=edges[e][1];
        int wt=edges[e][2];
        if(arr[u]==INT_MAX)
            continue;
        if(arr[u]+wt<arr[v]){
            arr[v]=arr[u]+wt;
            return 1;
        }
    }
    return 0;
}
int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        int n,e;
        cin>>n>>e;
        vector<vector<int>> edges(e,vector<int>(3));
        for(int i=0;i<e;i++)
        {
            for(int j=0;j<3;j++)
            {
                cin>>edges[i][j];
            }
        }
        vector<int> shortestPath(n,INT_MAX);
        shortestPath[0]=0;
        cout<<bellmanFord(n,edges,shortestPath)<<endl;
    }
	return 0;
}