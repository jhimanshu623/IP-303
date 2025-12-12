#include<iostream>
using namespace std;

unordered_map<int,int> map1;
TreeNode* buildTree_(vector<int>& inorder,int isi,int iei,vector<int>& postorder,int psi,int pei)
{
    if(psi>pei || isi>iei)
        return nullptr;
    TreeNode* node=new TreeNode(postorder[pei]);
    int idx=map1[postorder[pei]];
    int count=idx-isi;
    node->left=buildTree_(inorder,isi,idx-1,postorder,psi,psi+count-1);
    node->right=buildTree_(inorder,idx+1,iei,postorder,psi+count,pei-1);
    return node;
}
TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
    for(int i=0;i<inorder.size();i++)
        map1[inorder[i]]=i;
    return buildTree_(inorder,0,inorder.size()-1,postorder,0,postorder.size()-1);
}

// sir method
// unordered_map<int,int> map1;
// TreeNode* buildTree_(vector<int>& inorder,int isi,int iei,vector<int>& postorder,int psi,int pei)
// {
//     if(psi>pei || isi>iei)
//         return nullptr;
//     TreeNode* node=new TreeNode(postorder[pei]);
//     int idx=map1[postorder[pei]];
//     int count=iei-idx;
//     node->left=buildTree_(inorder,isi,idx-1,postorder,psi,pei-count-1);
//     node->right=buildTree_(inorder,idx+1,iei,postorder,pei-count,pei-1);
//     return node;
// }
// TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
//     for(int i=0;i<inorder.size();i++)
//         map1[inorder[i]]=i;
//     return buildTree_(inorder,0,inorder.size()-1,postorder,0,postorder.size()-1);
// }

int main(int args,char** argv)
{
    return 0;
}