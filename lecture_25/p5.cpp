#include<iostream>
#include<stack>

using namespace std;

int minAddToMakeValid(string s) {
    stack<char> st;
    for(char c:s)
    {
        if(c=='(')
            st.push(c);
        else
        {
            if(st.size()==0)
                st.push(c);
            else if(st.top()==')')
                st.push(c);
            else
                st.pop();
        }
    }
    // int oc=0;
    // int cc=0;
    // int ans=0;
    // while(st.size()>0)
    // {
    //     if(st.top()=='(')
    //     {
    //         oc++;
    //         st.pop();
    //     }
    //     else
    //     {
    //         cc++;
    //         st.pop();
    //     }
    // }
    // return (oc+cc);
    return st.size();
}

int main(int args,char** argv)
{
    string s="()))((";
    cout<<minAddToMakeValid(s)<<endl;
    return 0;
}