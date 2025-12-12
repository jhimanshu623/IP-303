#include<iostream>
#include<stack>

using namespace std;

stack<char> backspaceCompare_(string s)
{
    stack<char> st;
    for(char c:s)
    {
        if(st.size()>0 && c=='#')
            st.pop();
        else
            st.push(c);
    }
    return st;
}
bool backspaceCompare(string s, string t) {
    stack<char> st1=backspaceCompare_(s);
    stack<char> st2=backspaceCompare_(t);
    while(st1.size()>0 && st2.size()>0)
    {
        if(st1.top()==st2.top())
        {
            st1.pop();
            st2.pop();
        }
        else
            return false;
    }
    if(st1.size()==0 && st2.size()==0)
        return true;
    return false;
}

// O(1) space
bool backspaceCompare2(string s, string t) {
    int count1=0;
    int count2=0;
    int i=s.length()-1;
    int j=t.length()-1;
    while(true)
    {
        while(i>=0)
        {
            if(s[i]=='#')
                count1++;
            else
            {
                if(count1>0)
                    count1--;
                else
                    break;
            }
            i--;
        }
        while(j>=0)
        {
            if(t[j]=='#')
                count2++;
            else
            {
                if(count2>0)
                    count2--;
                else
                    break;
            }
            j--;
        }
        if(i<0 && j<0)
            return true;
        else if(i<0 || j<0)
            return false;
        else if(s[i]!=t[j])
            return false;
        else
        {
            i--;
            j--;
        }
    }
    return true;
}

int main(int args,char** argv)
{
    string s="ab#cde#e##";
    string t="abc##cde##ef##";
    cout<<boolalpha<<backspaceCompare(s,t)<<endl;
    cout<<boolalpha<<backspaceCompare2(s,t)<<endl;
    return 0;
}