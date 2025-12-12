#include<iostream>
#include<vector>
using namespace std;

class kqueue
{
    public:
        vector<int> arr;
        vector<int> front;
        vector<int> end;
        vector<int> next;
        int free;
        int size;
        kqueue(int n,int k)
        {
            arr.assign(n,0);
            front.assign(k,-1);
            end.assign(k,-1);
            next.assign(n,0);
            for(int i=0;i<n;i++)
                next[i]=i+1;
            next[n-1]=-1;
            size=0;
            free=0;
        }
        void enque(int val,int qn)
        {
            if(size==arr.size())
            {
                cout<<"queue is full"<<endl;
                return;
            }
            arr[free]=val;
            int nas=next[free];
            if(front[qn]==-1)
            {
                front[qn]=free;
                end[qn]=free;
            }
            else
            {
                next[end[qn]]=free;
                end[qn]=free;   
            }
            next[free]=-1;
            free=nas;
            size++;
        }
        int dequeue(int qn)
        {
            if(size==0)
            {
                cout<<"queue is empty.."<<endl;
                return -1;
            }
            int temp=front[qn];
            int ans=arr[temp];
            arr[temp]=0;
            if(front[qn]==end[qn])
                end[qn]=-1;
            front[qn]=next[temp];
            next[temp]=free;
            free=temp;
            size--;
            return ans;
        }
};
int main(int args,char **argv)
{
    kqueue que(10,3);
    que.enque(5,2);
    que.enque(6,2);
    que.enque(7,2);
    que.enque(8,1);
    que.enque(9,1);
    que.enque(10,0);
    que.enque(3,0);
    que.enque(4,0);
    cout<<que.dequeue(2)<<endl;
    return 0;
}