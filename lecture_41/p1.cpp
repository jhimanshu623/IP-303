#include <iostream>
#include<vector>
#include<climits>
using namespace std;

void floydWarshall(int n,int** arr)
{
    for(int k=0;k<n;k++)
    {
        for(int i=0;i<n;i++)
        {
            if(i==k)
                continue;
            for(int j=0;j<n;j++)
            {
                if(j==k || arr[i][k]==INT_MAX || arr[k][j]==INT_MAX)
                    continue;
                arr[i][j]=min(arr[i][j],arr[i][k]+arr[k][j]);
            }
        }
    }
    
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(arr[i][j]==1e7)
                cout<<"INF ";
            else
                cout<<arr[i][j]<<" ";
        }
        cout<<"\n";
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int t;
    cin>>t;
    while(t-->0)
    {
        int n;
        cin>>n;
        int** arr=new int*[n];
        
        for(int i=0;i<n;i++) {
            arr[i]=new int[n];
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                cin>>arr[i][j];
            }
        }
        floydWarshall(n,arr);
    }   
	return 0;
}