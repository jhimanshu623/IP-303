#include<iostream>
using namespace std;

ListNode* reverseList(ListNode* cur) {
    ListNode* prev=NULL;
    while(cur!=NULL)
    {
        ListNode* n=cur->next;
        cur->next=prev;
        prev=cur;
        cur=n;
    }
    return prev;
}

int main(int args,char** argv)
{
    return 0;
}