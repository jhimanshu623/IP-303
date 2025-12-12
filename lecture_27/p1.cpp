#include<iostream>
#include<stack>
using namespace std;


// using two stack

// stack<int> st1;
// stack<int> st2;
// MinStack() {
    
// }

// void push(int x) {
//     st1.push(x);
//     if(st2.size()==0)
//         st2.push(x);
//     else
//         st2.push(min(x,st2.top()));
// }

// void pop() {
//     st1.pop();
//     st2.pop();
// }

// int top() {
//     return st1.top();
// }

// int getMin() {
//     return st2.top();
// }


// using two stacks ,but a little more efficient
// https://leetcode.com/problems/min-stack/discuss/572005/SUPER-EASY-C%2B%2B-SOLUTION-WITH-EXPLANATION

// alternative of using pair
// https://leetcode.com/problems/min-stack/discuss/571959/Java-solution-using-O(N)-time-and-O(1)-space



// using one stack
stack<long long int> st;
    long long int m;
    MinStack() {
        
    }
    
    void push(int x) {
        if(st.size()==0)
        {
            m=x;
            st.push(x-m);
        }
        else
        {
            st.push(x-m);
            if(x<m)
                m=x;
        }
    }
    
    void pop() {
        if(st.top()<0)
            m=m-st.top();
        st.pop();
    }
    
    int top() {
        int rv;
        if(st.top()<0){
            rv=m;
        }
        else
            rv=(int)(m+st.top());
        return rv;
    }
    
    int getMin() {
        return (int)m;
    }


int main(int args,char **argv)
{

    return 0;
}