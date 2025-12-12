#include<iostream>
#include<stack>
#include<vector>
using namespace std;

class kstacks
{
    public:
        vector<int> arr;
        vector<int> top;
        vector<int> next;
        int free;
        int size=0;
        kstacks(int n,int k)
        {
            arr.assign(n,0);
            top.assign(k,-1);
            next.assign(n,0);
            for(int i=0;i<next.size()-1;i++)
            {
                next[i]=i+1;
            }
            next[next.size()-1]=-1;
            free=0;
        }
        void push(int val,int sn)
        {
            if(size==arr.size())
            {
                cout<<"stack full "<<endl;
                return;
            }
            arr[free]=val;
            int nas=next[free];
            next[free]=top[sn];
            top[sn]=free;
            free=nas;
            size++;
        }
        int pop(int sn)
        {
            if(size==0)
            {
                cout<<"stack is empty.."<<endl;
                return -1;
            }
            int temp=top[sn];
            int ans=arr[temp];
            arr[temp]=0;
            top[sn]=next[temp];
            next[temp]=free;
            free=temp;
            size--;
            return ans;
        }
};


int main(int args,char **argv)
{
    kstacks st(10,3);
    st.push(4,1);
    st.push(6,0);
    st.push(7,2);
    st.push(8,0);
    st.push(5,0);
    st.push(9,2);
    cout<<st.pop(1)<<endl;
    cout<<st.pop(0)<<endl;
    return 0;
}