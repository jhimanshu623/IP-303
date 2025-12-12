#include <iostream>
#include<vector>
using namespace std;

bool eulerianPath(vector<vector<int>>& g,int n)
{
    vector<int> od;
    for(int i=0;i<n;i++)
    {
        int d=0;
        for(int j=0;j<n;j++)
        {
            if(i!=j && g[i][j]==1)
                d++;
        }
        if(d%2!=0)
        {
            if(od.size()==2)
                return false;
            od.push_back(i);
        }
    }    
    return true;
}
int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        int n;
        cin>>n;
        vector<vector<int>> g(n,vector<int>(n,0));
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                cin>>g[i][j];
            }
        }
        cout<<eulerianPath(g,n)<<endl;
    }
	return 0;
}