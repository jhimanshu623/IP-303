#include<iostream>
#include<climits>
#include<vector>

using namespace std;

int maxDistToClosest(vector<int>& seats) {
    int idx=-1;
    int ans=INT_MIN;
    for(int i=0;i<seats.size();i++)
    {
        if(seats[i]==1)
        {
            if(idx==-1)
                ans=i;
            else
                ans=max(ans,(idx+i)/2-idx);
            idx=i;
        }
    }
    int f=seats.size()-1-idx;
    ans=max(ans,f);
    return ans;
}

int main(int args,char** argv)
{
    vector<int> seats={1,0,0,0,1,0,1};
    cout<<maxDistToClosest(seats);
    return 0;
}