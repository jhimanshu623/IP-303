#include<iostream>
using namespace std;

unordered_map<int,int> map1;
TreeNode* buildTree_(vector<int>& lorder,vector<int>& inorder,int isi,int iei)
{
    if(isi>iei)
        return nullptr;
    TreeNode* node=new TreeNode(lorder[0]);
    int idx=map1[lorder[0]];
    vector<int> lleft;
    vector<int> lright;
    for(int i=1;i<lorder.size();i++)
    {
        if(map1[lorder[i]]<idx)
            lleft.push_back(lorder[i]);
        else
            lright.push_back(lorder[i]);
    }
    node->left=buildTree_(lleft,inorder,isi,idx-1);
    node->right=buildTree_(lright,inorder,idx+1,iei);
    return node;
}
TreeNode* buildTree(vector<int>& lorder,vector<int>& inorder)
{
    for(int i=0;i<inorder.size();i++)
        map1[inorder[i]]=i;
    return buildTree_(lorder,inorder,0,inorder.size()-1);
}

int main(int args,char** argv)
{
    return 0;
}