#include <iostream>
#include<unordered_map>
using namespace std;
#define mod 1000000007

class Node
{   
    public:
    int val;
    Node* left;
    Node* right;
    Node(int val){
        this->val=val;
        this->left=nullptr;
        this->right=nullptr;
    }
};
int sum=0;
void solve(Node* node1,Node* node2)
{
    if(node1==nullptr || node2==nullptr)
        return;
    sum = (sum%mod + (node1->val*node2->val)%mod)%mod;
    solve(node1->left,node2->right);
    solve(node1->right,node2->left);
}
int imageMul(Node* root)
{
    if(root==nullptr)   
        return 0;
    // int mod=1000000007;    
    solve(root->left,root->right);
    sum=(sum%mod+(root->val * root->val)%mod)%mod;
    return sum;
}
int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        int n;
        cin>>n;
        unordered_map<int,Node*> map1;
        Node* root=nullptr;
        while(n-->0)
        {
            int par;
            cin>>par;
            int child;
            cin>>child;
            char ch;
            cin>>ch;
            
            Node* p;
            if(map1.count(par)==0)
            {
                p=new Node(par);
                map1[par]=p;                
            }
            else
                p=map1[par];
            Node* c=new Node(child);
            map1[child]=c;
            
            if(ch=='R')
                p->right=c;
            else
                p->left=c;
            if(root==nullptr)
                root=p;
        }
        sum=0;
        cout<<imageMul(root)<<endl;
    }
	return 0;
}