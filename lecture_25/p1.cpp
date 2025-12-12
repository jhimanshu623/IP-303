#include<iostream>
#include<stack>
#include<vector>

using namespace std;

bool isValid(string s) {
    stack<char> st;
    for(char c:s)
    {
        if(c=='(' || c=='[' || c=='{')
            st.push(c);
        else
        {
            if(st.size()==0)
                return false;
            else if(c==')' && st.top()=='(')
                st.pop();
            else if(c==']' && st.top()=='[')
                st.pop();
            else if(c=='}' && st.top()=='{')
                st.pop();
            else
                return false;
        }
    }
    return st.size()==0;
}

int main(int args,char** argv)
{
    string s="{[()]()}";
    cout<<boolalpha<<isValid(s)<<endl;
    return 0;
}