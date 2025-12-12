#include<iostream>
using namespace std;

ListNode* middleNode(ListNode* head) {
    ListNode* slow=head;
    ListNode* fast=head;
    while(fast!=nullptr && fast->next!=nullptr)
    {
        slow=slow->next;
        fast=fast->next->next;
    }
    return slow;
}

int main(int args,char** argv)
{
    return 0;
}