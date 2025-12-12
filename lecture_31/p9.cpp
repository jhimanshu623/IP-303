#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int ans=0;
int solve(TreeNode* node)
{
    if(node==nullptr)
        return 3;
    int lc=solve(node->left);
    int rc=solve(node->right);
    if(lc == 1 || rc == 1)
    {
        ans++;
        return 2;
    }
    else if(lc==2 || rc == 2)
        return 3;
    else
        return 1;
}
int minCameraCover(TreeNode* root) {
    int c=solve(root);
    if(c==1)
        ans++;
    return ans;
}


int main(int args,char** argv)
{
    return 0;
}