#include<iostream>
using namespace std;

int main(int args,char** argv) {
    int t;
    cin>>t;
    while(t-->0)
    {
        int n;
        cin>>n;
        int** arr=new int*[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=new int[n];
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                cin>>arr[i][j];
        }
        int c=0;
        int i=0;
        for(i=0;i<n;i++)
        {
            c=0;
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==1)
                    c++;
            }
            if((c==0 && n>1) || (c%2!=0))
            {
                cout<<"False"<<endl;
                break;
            }
        }
        if(i==n)
        {
            cout<<"True"<<endl;
        }
    }
	return 0;
}


int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        int n;
        cin>>n;
        int c=0;
        int i=0;
        bool flag=true;
        for(i=0;i<n;i++)
        {
            c=0;
            for(int j=0;j<n;j++)
            {
                int u;
                cin>>u;
                if(u==1)
                    c++;
            }
            if((flag==true) && ((c==0 && n>1) || (c%2!=0)))
            {
                cout<<"False"<<endl;
                flag=false;
            }
        }
        if(flag==true)
        {
            cout<<"True"<<endl;
        }
    }
	return 0;
}