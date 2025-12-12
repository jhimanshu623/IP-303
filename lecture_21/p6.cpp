#include<iostream>
#include<vector>
using namespace std;

// 50ms
int findMaxConsecutiveOnes2(vector<int> &arr) {
    int ans=0;
    int idx=-1;
    int j=0;
    for(int i=0;i<arr.size();i++)
    {
        if(arr[i]==0)
        {
            j=idx+1;
            idx=i;
        }
        ans=max(ans,i-j+1);
    }
    return ans;
}


// 50ms
// int findMaxConsecutiveOnes(vector<int> &arr) {
//     int ans=0;
//     int lc=0;
//     int rc=0;
//     bool isz=false;
//     for(int i=0;i<arr.size();i++)
//     {
//         if(arr[i]==1)
//         {
//             if(isz==false)
//                 lc++;
//             else
//                 rc++;
//         }
//         else
//         {
//             if(isz==false)
//             {
//                 isz=true;
//             }
//             else
//             {
//                 ans=max(ans,lc+rc+1);
//                 lc=rc;
//                 rc=0;
//             }
//         }
//     }
//     ans=max(ans,lc+rc+1);
//     return ans;
// }

int main(int args,char** argv)
{
    vector<int> arr={1,0,1,0,1};
    cout<<findMaxConsecutiveOnes(arr)<<endl;
    cout<<findMaxConsecutiveOnes2(arr)<<endl;
    return 0;
}