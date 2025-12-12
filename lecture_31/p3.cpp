#include<iostream>
#include<queue>
#include<vector>
using namespace std;

// using bfs
void leftView(Node *root)
{
    queue<Node*> que;
    if(root!=nullptr)
        que.push(root);
    while(que.size()>0)
    {
        int size=que.size();
        cout<<que.front()->data<<" ";
        while(size-->0)
        {
            Node* rn=que.front();
            que.pop();
            if(rn->left!=nullptr)
                que.push(rn->left);
            if(rn->right!=nullptr)
                que.push(rn->right);
        }
    }
}

int main(int args,char** argv)
{

    return 0;
}