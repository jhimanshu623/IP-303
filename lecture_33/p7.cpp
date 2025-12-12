#include<iostream>
using namespace std;

// Encodes a tree to a single string.
string serialize(TreeNode* node) {
    if(node==nullptr)
        return "#";
    string ls=serialize(node->left);
    string rs=serialize(node->right);
    return to_string(node->val)+" "+ls+" "+rs;
}

TreeNode* deserialize_(string data,int& i)
{
    if(data[i]=='#'){
        i++;        //required because of space otherwise not required
        return nullptr;
    }
    string num="";
    while(data[i]!=' '){     //loop for splitting the string
        num+=string(1,data[i]);
        i++;
    }
    TreeNode* node=new TreeNode(stoi(num));
    i++;
    node->left=deserialize_(data,i);
    i++;
    node->right=deserialize_(data,i);
    return node;
}
// Decodes your encoded data to tree.
TreeNode* deserialize(string data) {
    int i=0;
    return deserialize_(data,i);
}

// solution 2
// using queue because of remove first 

// Encodes a tree to a single string.
string serialize(TreeNode* node) {
    if(node==nullptr)
        return "#";
    string ls=serialize(node->left);
    string rs=serialize(node->right);
    return to_string(node->val)+" "+ls+" "+rs;
}
TreeNode* deserialize_(queue<string>& que)
{
    if(que.front()=="#")
    {
        que.pop();
        return nullptr;
    }
    TreeNode* node=new TreeNode(stoi(que.front()));
    que.pop();
    node->left=deserialize_(que);
    node->right=deserialize_(que);
    return node;
}
// Decodes your encoded data to tree.
TreeNode* deserialize(string data) {
    queue<string> que;
    for(int i=0;i<data.length();i++)
    {
        string num="";
        while(i<data.length() && data[i]!=' '){
            num+=string(1,data[i]);
            i++;
        }
        que.push(num);
    }
    return deserialize_(que);
}

int main(int args,char** argv)
{
    return 0;
}