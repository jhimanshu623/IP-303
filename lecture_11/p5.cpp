#include<iostream>
#include<vector>
#include<queue>
using namespace std;

// O(n^2 (2logn) )
// 116ms
int kthSmallest2(vector<vector<int>>& matrix, int k) {\
    priority_queue<int,vector<int>,greater<int>> pq;
    for(int i=0;i<matrix.size();i++)
    {
        for(int j=0;j<matrix[i].size();j++)
            pq.push(matrix[i][j]);
    }
    int count=0;
    while(pq.size()>0)
    {
        int p=pq.top(); pq.pop();
        count++;
        if(count==k)
            return p;
    }
    return -1;
}


class Pair
{
    public:
        int v;
        int r;
        int c;
        Pair(int v,int r,int c)
        {
            this->v=v;
            this->r=r;
            this->c=c;
        }
        bool operator>(const Pair& other)const
        {
            return this->v > other.v;
        }
};

// O(n^2 logn)
// 108ms
int kthSmallest(vector<vector<int>>& matrix, int k) {
    priority_queue<Pair,vector<Pair>,greater<Pair>> pq;
    for(int i=0;i<matrix.size();i++)
        pq.push(Pair(matrix[i][0],i,0));
    int count=0;
    while(pq.size()>0)
    {
        Pair p=pq.top(); pq.pop();
        count++;
        if(count==k)
            return p.v;
        if(p.c+1<matrix[p.r].size())
            pq.push(Pair(matrix[p.r][p.c+1],p.r,p.c+1));
    }
    return -1;
}

// 212ms
int partition(vector<int>& mat,int s,int e,int k)
{
    while(s<=e)
    {
        int pivot=mat[e];
        int pi=s;
        int i=s;
        while(i<=e)
        {
            if( mat[i] <= pivot)
            {
                int temp=mat[i];
                mat[i]=mat[pi];
                mat[pi]=temp;
                pi++;
            }
            i++;
        }
        pi--;
        if(pi==k)
            return mat[pi];
        else if(pi<k)
            s=pi+1;
        else
            e=pi-1;
    }
    return -1;
}


// using binary search
// O(nlog(max-min))
// 36ms
int countLessEqual(vector<vector<int>>& matrix,int mid,pair<int, int> &smallLargePair)
{
    int r=matrix.size()-1;
    int c=0;
    int count=0;
    while(r>=0 && c<matrix[0].size())
    {
        if(matrix[r][c]>mid)
        {
            smallLargePair.second=min(smallLargePair.second,matrix[r][c]);
            r--;
        }
        else
        {
            count+=r+1;
            smallLargePair.first=max(smallLargePair.first,matrix[r][c]);
            c++;
        }
    }
    return count;
}
int kthSmallest4(vector<vector<int>>& matrix, int k) {
    int s=matrix[0][0];
    int e=matrix[matrix.size()-1][matrix[0].size()-1];
    while(s<e)
    {
        int mid=s+(e-s)/2;
        pair<int, int> smallLargePair={matrix[0][0],matrix[matrix.size()-1][matrix[0].size()-1]};
        int count=countLessEqual(matrix,mid,smallLargePair);
        if(count==k)
            return smallLargePair.first;
        else if(count<k)
            s=smallLargePair.second;
        else
            e=smallLargePair.first;
    }
    return s;
}


int main(int args,char** argv)
{
    vector<vector<int>> matrix={
        { 1,  5,  9},
        {10, 11, 13},
        {12, 13, 15}
    };
    int k=8;
    cout<<kthSmallest(matrix,k)<<endl;
    cout<<kthSmallest2(matrix,k)<<endl;
    vector<int> mat;
    for(int i=0;i<matrix.size();i++)
    {
        for(int j=0;j<matrix[0].size();j++)
            mat.push_back(matrix[i][j]);
    }
    cout<<partition(mat,0,mat.size()-1,k-1)<<endl;
    cout<<kthSmallest4(matrix,k)<<endl;
    return 0;
}
