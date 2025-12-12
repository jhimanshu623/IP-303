#include<iostream>
#include<queue>
#include<vector>
using namespace std;

// using bfs
vector<int> Solution::solve(TreeNode* node) {
    unordered_map<int,vector<int>> map1;
    queue<pair<TreeNode*,int>> que;
    if(node!=nullptr)
        que.push(make_pair(node,0));
    int mi=0;
    while(que.size()>0)
    {
        int size=que.size();
        while(size-- > 0)
        {
            pair<TreeNode*,int> rp=que.front();
            que.pop();
            
            mi=min(mi,rp.second);
            map1[rp.second].push_back(rp.first->val);
            
            if(rp.first->left!=nullptr)
                que.push(make_pair(rp.first->left,rp.second-1));
            if(rp.first->right!=nullptr)
                que.push(make_pair(rp.first->right,rp.second));
        }
    }
    vector<int> res;
    for(int i=0;i>=mi;i--)
    {
        for(int v:map1[i])
            res.push_back(v);
    }
    return res;
}

// https://www.interviewbit.com/problems/diagonal-traversal/#
// using dfs prioritizing node that comes first in preorder
void solve_(TreeNode* node,int vl,unordered_map<int,vector<int>>& map1,int& mi)
{
    if(node==nullptr)
        return;
    mi=min(mi,vl);
    map1[vl].push_back(node->val);
    solve_(node->left,vl-1,map1,mi);
    solve_(node->right,vl,map1,mi);
}[]
vector<int> Solution::solve(TreeNode* node) {
    unordered_map<int,vector<int>> map1;
    int mi=0;
    solve_(node,0,map1,mi);
    vector<int> res;
    for(int i=0;i>=mi;i--)
    {
        for(int v:map1[i])
            res.push_back(v);
    }
    return res;
}


int main(int args,char** argv)
{
    return 0;
}