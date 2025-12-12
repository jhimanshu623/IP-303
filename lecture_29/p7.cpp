#incluse<iostream>
using namespace std;

int getStartingPoint(Node* head2)
{
    Node* s=head2;
    Node* f=head2;
    while(f!=NULL)
    {
        s=s->next;
        f=f->next->next;
        if(f==s)
        {
            s=head2;
            while(s!=f)
            {
                s=s->next;
                f=f->next;
            }
            return s->data;
        }
    }
}
int intersectPoint(Node* head1, Node* head2)
{
    Node* cur=head1;
    while(cur->next!=NULL)
        cur=cur->next;
    cur->next=head1;
    return getStartingPoint(head2);
}

// solution 2

int getSize(Node* head)
{
    int size=0;
    while(head!=NULL)
    {
        size++;
        head=head->next;
    }
    return size;
}

int intersectPoint(Node* head1, Node* head2)
{
    int size1=getSize(head1);
    int size2=getSize(head2);
    Node* cur1;
    Node* cur2;
    int k;
    if(size1<size2)
    {
        cur1=head2;
        cur2=head1;
        k=size2-size1;
    }
    else
    {
        cur1=head1;
        cur2=head2;
        k=size1-size2;
    }
    while(k-->0)
         cur1=cur1->next;
    while(cur1!=cur2)
    {
        cur1=cur1->next;
        cur2=cur2->next;
    }
    return cur1->data;
}


int main(int args,char** argv)
{
    return 0;
}