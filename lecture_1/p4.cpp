#include<iostream>
#include<vector>
using namespace std;

int maximalSquare(vector<vector<char>>& matrix) 
{
    int ans=0;
    for(int i=matrix.size()-1;i>=0;i--)
    {
        for(int j=matrix[0].size()-1;j>=0;j--)
        {
            if(i==matrix.size()-1)
                matrix[i][j]=matrix[i][j];
            else if(j==matrix[0].size()-1)
                matrix[i][j]=matrix[i][j];
            else if(matrix[i][j]!='0'){
                matrix[i][j]=(char)((min(matrix[i+1][j+1]-'0',min(matrix[i][j+1]-'0',matrix[i+1][j]-'0'))+1)+'0');
            }
            if(matrix[i][j]-'0'>ans)
                ans=matrix[i][j]-'0';
        }
    }
    if(ans==0)
        return 0;
    return ans*ans;   
}
int main(int args,char** argv)
{
    vector<vector<char>> matrix={
        {'1','0','1','0','0'},
        {'1','0','1','1','1'},
        {'1','1','1','1','1'},
        {'1','0','0','1','0'}
    };
    cout<<maximalSquare(matrix)<<endl;
    return 0;
}   