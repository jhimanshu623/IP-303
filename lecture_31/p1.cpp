#include<iostream>
using namespace std;

int sum=0;
TreeNode* bstToGst(TreeNode* root) {
    if(root==nullptr)
        return nullptr;
    root->right=bstToGst(root->right);
    sum+=root->val;
    root->val=sum;
    root->left=bstToGst(root->left);
    return root;
}

int main(int args,char** argv)
{
    
    return 0;
}