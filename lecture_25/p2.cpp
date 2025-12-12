#include<iostream>
#include<stack>
#include<vector>

using namespace std;

int longestValid(string s)
{
    int ans=0;
    stack<int> st;
    st.push(-1);
    for(int i=0;i<s.length();i++)
    {
        if(s[i]=='(')
            st.push(i);
        else
        {
            if(st.top()==-1)
                st.push(i);
            else if(s[st.top()]==')')
                st.push(i);
            else
            {
                int len=0;
                st.pop();
                len=i-st.top();
                ans=max(ans,len);
            }   
        }
    }
    return ans;
}


int main(int args,char** argv)
{
    string s="()(()))))";
    cout<<longestValid(s)<<endl;
    return 0;
}