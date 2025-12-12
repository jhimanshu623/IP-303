#include<iostream>
using namespace std;

TreeNode* deleteNode(TreeNode* node, int key) {
    if(node==nullptr)
        return nullptr;
    if(node->val==key)
    {
        if(node->left==nullptr && node->right==nullptr)
            return nullptr;
        else if(node->left==nullptr)
            return node->right;
        else if(node->right==nullptr)
            return node->left;
        else
        {
            TreeNode* cur=node->left;
            while(cur->right!=nullptr)
                cur=cur->right;
            node->val=cur->val;
            node->left=deleteNode(node->left,cur->val);
        }
        return node;
    }
    else if(key<node->val)
        node->left=deleteNode(node->left,key);
    else
        node->right=deleteNode(node->right,key);
    return node;
}
int main(int args,char argv)
{
    return 0;
}