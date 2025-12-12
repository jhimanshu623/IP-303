#include<iostream>
#include<stack>
#include<vector>

using namespace std;

// 32ms
vector<int> asteroidCollision(vector<int>& asteroids) {
    stack<int> st;
    for(int val:asteroids)
    {
        if(val>=0)
            st.push(val);
        else
        {
            while(st.size()>0 && st.top()>=0 && st.top()<(-val))
                st.pop();
            if(st.size()==0 || st.top()<0)
                st.push(val);
            if(st.top()==(-val))
                st.pop();
        }
    }
    vector<int> res(st.size());
    for(int i=res.size()-1;i>=0;i--)
    {
        res[i]=st.top();
        st.pop();
    }
    return res;
}

// using array as a stack
// 28 ms
// O(1) space
vector<int> asteroidCollision2(vector<int>& asteroids) {
    vector<int> st;
    int top=-1;
    for(int val:asteroids)
    {
        if(val>0)
        {
            top++;
            st.push_back(val);
        }
        else
        {
            while(top>-1 && st[top]>0 && st[top]<abs(val))
            {
                top--;
                st.pop_back();
            }
            if(top==-1 || st[top]<0)
            {
                top++;
                st.push_back(val);
            }
            else if(st[top]==abs(val))
            {
                top--;
                st.pop_back();
            }
        }
    }
    return st;
}


int main(int args,char** argv)
{
    vector<int> arr={-10,4,5,-3,-6,12,9,-9,14};
    // vector<int> res=asteroidCollision(arr);
    vector<int> res=asteroidCollision2(arr);
    for(int i:res)
        cout<<i<<" ";
    cout<<endl;
    return 0;
}