#include<iostream>
#include<stack>

using namespace std;

int longestUnbalancedSubSeq(string s)
{
    stack<char> st;
    for(char c:s)
    {
        if(c=='(')
            st.push(c);
        else
        {
            if(st.size()==0)
            {
                st.push(c);
                break;
            }
            if(st.top()=='(')
                st.pop();
        }
    }
    if(st.size()==0)
        return s.length()-1;
    return s.length();
}

int main(int args,char** argv)
{
    string s="(()()(((()())(";
    cout<<longestUnbalancedSubSeq(s);
    return 0;
}