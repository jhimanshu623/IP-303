#include<iostream>
using namespace std;

bool hasCycle(ListNode *head) {
    ListNode* s=head;
    ListNode* f=head;
    while(f!=NULL && f->next!=NULL)
    {
        s=s->next;
        f=f->next->next;
        if(s==f)
            return true;
    }
    return false;
}

// to find starting point
// https://www.lintcode.com/problem/linked-list-cycle-ii/description
ListNode * detectCycle(ListNode * head) {
    ListNode* s=head;
    ListNode* f=head;
    while(f!=NULL && f->next!=NULL)
    {
        s=s->next;
        f=f->next->next;
        if(s==f)
        {
            s=head;
            while(s!=f)
            {
                s=s->next;
                f=f->next;
            }
            return s;
        }
    }
    return NULL;
}


// alternative O(n) time ,O(1) space
// https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/


int main(int args,char** argv)
{
    return 0;
}