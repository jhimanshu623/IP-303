#include<iostream>
using namespace std;

void splitList(Node *head, Node **head1_ref, Node **head2_ref)
{
    Node* s=head;
    Node* f=head;
    while(f->next!=head && f->next->next!=head)
    {
        s=s->next;
        f=f->next->next;
    }
    if(f->next->next==head)
        f=f->next;
    Node* sn=s->next;
    s->next=head;
    f->next=sn;
    *head1_ref=head;
    *head2_ref=sn;
}

int main(int args,char** argv)
{
    return 0;
}