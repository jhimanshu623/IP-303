#include<iostream>
using namespace std;

int ans=0;
int solve(TreeNode* node)
{
    if(node==nullptr)
        return 0;
    int l=solve(node->left);
    int r=solve(node->right);
    ans+=abs(l)+abs(r);
    return l+r+node->val-1;
}
int distributeCoins(TreeNode* root) {
    solve(root);
    return ans;
}

int main(int args,char** argv)
{
    return 0;
}