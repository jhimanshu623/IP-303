#include<iostream>
#include<queue>
#include<vector>
using namespace std;

// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

void topView(struct Node *root)
{
    unordered_map<int,int> map1;
    int mi=0;
    int ma=0;
    queue<pair<Node*,int>> que;
    if(root!=nullptr)
        que.push(pair<Node*,int>(root,0));
    while(que.size()>0)
    {
        int size=que.size();
        while(size-->0)
        {
            pair<Node*,int> rp=que.front();
            que.pop();
            mi=min(mi,rp.second);
            ma=max(ma,rp.second);
            if(map1.count(rp.second)==0)
                map1[rp.second]=rp.first->data;
            if(rp.first->left!=nullptr)
                que.push(pair<Node*,int> (rp.first->left,rp.second-1));
            if(rp.first->right!=nullptr)
                que.push(pair<Node*,int> (rp.first->right,rp.second+1));
        }
    }
    for(int i=mi;i<=ma;i++)
        cout<<map1[i]<<" ";
}

int main(int args,char** argv)
{
    return 0;
}