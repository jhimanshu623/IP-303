#include<iostream>
#include<queue>
#include<vector>
using namespace std;

// bfs
vector<int> rightSideView(TreeNode * root) {
    queue<TreeNode*> que;
    vector<int> res;
    if(root!=nullptr)
        que.push(root);
    while(que.size()>0)
    {
        int size=que.size();
        TreeNode* rn=nullptr;
        while(size-->0)
        {
            rn=que.front();
            que.pop();
            if(rn->left!=nullptr)
                que.push(rn->left);
            if(rn->right!=nullptr)
                que.push(rn->right);
        }
        res.push_back(rn->val);
    }
    return res;
}


// dfs
vector<int> res;
void solve(TreeNode* node,int d)
{
    if(node==nullptr)
        return;
    if(d>=res.size())
        res.push_back(node->val);
    solve(node->right,d+1);
    solve(node->left,d+1);
}
vector<int> rightSideView(TreeNode * root) {
    solve(root,0);
    return res;
}

// using dfs
public void solve(TreeNode node,int level,ArrayList<Integer> res)
{
    if(node==null)
        return;
    if(res.size()<=level)
        res.add(node.val);
    res.set(level,node.val);
    solve(node.left,level+1,res);
    solve(node.right,level+1,res);
}

int main(int args,char** argv)
{
    return 0;
}