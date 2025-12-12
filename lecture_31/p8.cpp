#include<iostream>
#include<queue>
#include<vector>
using namespace std;

vector<int> res;
void leftBoundary(TreeNode* node)
{
    if(node==nullptr)
        return;
    if(node->left!=nullptr){
        res.push_back(node->val);
        leftBoundary(node->left);
    }
    else if(node->right!=nullptr){
        res.push_back(node->val);
        leftBoundary(node->right);
    }
}

void leafs(TreeNode* node)
{
    if(node==nullptr)
        return;
    if(node->left==nullptr && node->right==nullptr)
    {
        res.push_back(node->val);
        return;
    }
    leafs(node->left);
    leafs(node->right);
}

void rightBoundary(TreeNode* node)
{
    if(node==nullptr)
        return;
    if(node->right!=nullptr){
        rightBoundary(node->right);
        res.push_back(node->val);
    }
    else if(node->left!=nullptr){
        rightBoundary(node->left);
        res.push_back(node->val);
    }
}

vector<int> boundaryOfBinaryTree(TreeNode * root) {
    if(root==nullptr)
        return res;
    res.push_back(root->val);
    leftBoundary(root->left);
    leafs(root);
    rightBoundary(root->right);
    return res;
}

int main(int args,char** argv)
{
    return 0;
}