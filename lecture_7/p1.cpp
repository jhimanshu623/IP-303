#include<iostream>
#include<vector>
using namespace std;

// not worked

double waterOverflow(double k,int row,int col)
{
    vector<vector<double>> strg(row,vector<double>(row,0.0));
    strg[0][0]=k;
    for(int i=0;i<row-1;i++)
    {
        for(int j=0;j<=i+1;j++)
        {
            if(strg[i][j]>1.0)
            {
                double ex=(strg[i][j]-1)/(2.0);
                strg[i+1][j]+=ex;
                strg[i+1][j+1]+=ex;
            }
        }
    }
    for(vector<double> ar:strg)
    {
        for(double d:ar)
            cout<<d<<" ";
        cout<<endl;
    }
    return strg[row-1][col-1];
}

int main(int args,char** argv)
{
    double k=9.0;
    int i=3;
    int j=3;
    printf("%.6f",waterOverflow(k,i,j));
    cout<<endl;
    return 0;
}