#include<iostream>
#include<stack>

using namespace std;

bool isDuplicates(string s)
{
    stack<char> st;
    for(char c:s)
    {
        if(c==')')
        {
            if(st.top()=='(')
                return true;
            while(st.top()!='(')
                st.pop();
            st.pop();
        }
        else
            st.push(c);
    }
    return false;
}

int main(int args,char** argv)
{
    string s="((a+b)+((c+d)))";
    cout<<boolalpha<<isDuplicates(s)<<endl;
    return 0;
}