#include<iostream>
#include<stack>

using namespace std;

int bracReversal(string s)
{
    stack<char> st;
    for(char c:s)
    {
        if(c=='{')
            st.push(c);
        else
        {
            if(st.size()==0)
                st.push(c);
            else if(st.top()=='}')
                st.push(c);
            else
                st.pop();
        }
    }
    int oc=0;
    int cc=0;
    int ans=0;
    while(st.size()>0)
    {
        if(st.top()=='{')
        {
            oc++;
            st.pop();
        }
        else
        {
            cc++;
            st.pop();
        }
    }
    if(oc%2==0 && cc%2==0)
        ans=oc/2 + cc/2;
    else
        ans=oc/2 + cc/2 + 2;
    return ans;
}

// better solution
int bracReversal(string s)
{
    stack<char> st;
    for(char c:s)
    {
        if(c=='{')
            st.push(c);
        else
        {
            if(st.size()!=0 && st.top()=='{')
                st.pop();
            else
                st.push(c);
        }
    }
    int oc=0;
    int cc=0;
    int ans=0;
    while(st.size()>0)
    {
        char ch=st.top();st.pop();
        if(ch=='{')
            oc++;
        else
            cc++;
    }
    if(oc%2 != cc%2)
        return -1;
    return oc/2+ cc/2 + oc%2 + cc%2;
}

int main(int args,char** argv)
{
    string s="}{{}}{{{";
    cout<<bracReversal(s)<<endl;
    return 0;
}