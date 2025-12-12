#include<iostream>
using namespace std;

void addLast(Node*& head,Node*& tail,Node* val)
{
    if(head==NULL){
        head=val;
        tail=val;
    }
    else
    {
        tail->next=val;
        tail=tail->next;
    }
}
Node *copyList(Node *head) {
    
    Node* nhead=NULL;
    Node* ntail=NULL;Node* temp=head;
    unordered_map<Node*,Node*> map1;
    
    // set next pointers
    while(temp!=NULL)
    {
        Node* n=new Node(temp->data);
        map1[temp]=n;
        addLast(nhead,ntail,n);
        temp=temp->next;
    }
    
    // set random pointers
    temp=head;
    Node* ntemp=nhead;
    while(temp!=NULL)
    {
        ntemp->arb=map1[temp->arb];
        temp=temp->next;
        ntemp=ntemp->next;
    }
    return nhead;
}

// O(1) space

Node *copyList(Node *head) {
    // set next pointers and mapping
    Node* temp=head;
    while(temp!=NULL)
    {
        Node* temp1=temp->next;
        Node* n=new Node(temp->data);
        temp->next=n;
        n->next=temp1;
        temp=temp1;
    }
    
    // set random pointers
    temp=head;
    while(temp!=NULL)
    {
        if(temp->arb!=NULL)
            temp->next->arb=temp->arb->next;
        temp=temp->next->next;
    }
    
    // extraction
    temp=head;
    Node* nhead=head->next;
    Node* ntemp=nhead;
    while(temp!=NULL)
    {
        Node* temp1;
        Node* ntemp1;
        if(ntemp->next==NULL)
        {
            temp1=NULL;
            ntemp1=NULL;
        }
        else
        {
            temp1=ntemp->next;
            ntemp1=temp1->next;
        }
        temp->next=temp1;
        ntemp->next=ntemp1;
        temp=temp1;
        ntemp=ntemp1;
    }
    return nhead;
}
int main(int args,char** argv)
{
    return 0;
}