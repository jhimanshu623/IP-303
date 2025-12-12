#include<iostream>
#include<queue>
#include<vector>
using namespace std;

class Pair
{
    public:
    Node* node;
    int l;
    Pair(Node* node,int l)
    {
        this->node=node;
        this->l=l;
    }
};
void bottomView(Node *root)
{
    unordered_map<int,int> map1;
    int mi=0;
    int ma=0;
    queue<Pair> que;
    if(root!=nullptr)
        que.push(Pair(root,0));
    while(que.size()>0)
    {
        int size=que.size();
        while(size-->0)
        {
            Pair rp=que.front();que.pop();
            mi=min(mi,rp.l);
            ma=max(ma,rp.l);
            map1[rp.l]=rp.node->data;
            if(rp.node->left!=nullptr)
                que.push(Pair(rp.node->left,rp.l-1));
            if(rp.node->right!=nullptr)
                que.push(Pair(rp.node->right,rp.l+1));
        }
    }
    for(int i=mi;i<=ma;i++)
        cout<<map1[i]<<" ";
}


int main(int args,char** argv)
{
    return 0;
}