#include<iostream>
#include<stack>
#include <bits/stdc++.h> 

using namespace std;

// 20ms
string removeKdigits(string s, int k) {
    stack<int> st;
    for(char c:s)
    {
        int val=c-'0';
        while(k>0 && st.size()>0 && st.top()>val){
            st.pop();
            k--;
        }
        // to handle leading zeros
        if(val!=0)
            st.push(val);
        if(val==0 && st.size()!=0)
            st.push(val);
    }
    while(k>0 && st.size()>0)
    {
        st.pop();
        k--;
    }
    string ans;
    while(st.size()>0)
    {
        ans+=to_string(st.top());
        st.pop();
    }
    reverse(ans.begin(),ans.end());
    if(ans.length()==0)
        return "0";
    return ans;
}


// 4ms
// O(1) space
string removeKdigits2(string s, int k) {
    string st="";
    for(char c:s)
    {
        while(k>0 && st.size()>0 && st[st.length()-1]>c){
            st.pop_back();
            k--;
        }
        if(c!='0')
            st.push_back(c);
        else if(st.size()!=0)
            st.push_back(c);
    }
    while(k>0 && st.size()>0)
    {
        st.pop_back();
        k--;
    }
    if(st.length()==0)
        return "0";
    return st;
}


int main(int args,char** argv)
{
    string s="10200";
    int k=1;
    cout<<removeKdigits(s,k)<<endl;
    cout<<removeKdigits2(s,k);
    return 0;
}