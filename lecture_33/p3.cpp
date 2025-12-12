#include<iostream>
using namespace std;

unordered_map<int,int> map1;
TreeNode* buildTree_(vector<int>& preorder,int psi,int pei, vector<int>& inorder,int isi,int iei)
{
    if(psi>pei)
        return nullptr;
    TreeNode* node=new TreeNode(preorder[psi]);
    int idx=map1[preorder[psi]];
    int count=idx-isi;
    node->left=buildTree_(preorder,psi+1,psi+count,inorder,isi,idx-1);
    node->right=buildTree_(preorder,psi+count+1,pei,inorder,idx+1,iei);
    return node;
}
TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    
    for(int i=0;i<inorder.size();i++)
        map1[inorder[i]]=i;
    return buildTree_(preorder,0,preorder.size()-1,inorder,0,inorder.size()-1);
}

int main(int args,char** argv)
{
    return 0;
}