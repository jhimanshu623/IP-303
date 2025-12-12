#include<iostream>
#include<queue>
#include<vector>
using namespace std;

static bool sortbysec(const pair<TreeNode*,int> &a, 
              const pair<TreeNode*,int> &b) 
{ 
    return (a.first->val < b.first->val); 
}

vector<vector<int>> verticalTraversal(TreeNode* root) {
    unordered_map<int,vector<int>> map1;
    queue<pair<TreeNode*,int>> que;
    int mi=0;
    int ma=0;
    if(root!=nullptr)
        que.push(pair<TreeNode*,int>(root,root->val));
    while(que.size()>0)
    {
        int size=que.size();
        vector<pair<TreeNode*,int>> temp;
        while(size-->0)
        {
            pair<TreeNode*,int> rp=que.front();
            que.pop();
            
            mi=min(mi,rp.second);
            ma=max(ma,rp.second);
            map1[rp.second].push_back(rp.first->val);
            
            if(rp.first->left!=nullptr)
                temp.push_back(pair(rp.first->left,rp.second-1));
            if(rp.first->right!=nullptr)
                temp.push_back(pair(rp.first->right,rp.second+1));
        }
        sort(temp.begin(),temp.end(),sortbysec);
        for(int i=0;i<temp.size();i++)
            que.push(temp[i]);
    }
    vector<vector<int>> res;
    for(int i=mi;i<=ma;i++){
        if(map1[i].size()>0)
            res.push_back(map1[i]);
    }
    return res;
}

int main(int args,char** argv)
{
    return 0;
}