#include<iostream>
#include<vector>
using namespace std;

// O(n2)
int jump(vector<int>& nums) 
{
    nums[nums.size()-1]=0;
    for(int i=nums.size()-2;i>=0;i--)
    {
        int m=nums.size();
        for(int j=i+1;j<=nums[i]+i && j<nums.size() ;j++)
        {
            m=min(m,nums[j]);
        }
        nums[i]=m+1;
    }    
    return nums[0];
}

// O(n)
int jump(vector<int>& nums) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int ans=0;
    int cend=0;
    int cmax=0;
    for(int i=0;i<nums.size();i++)
    {
        if(cend>=nums.size()-1)
            return ans;
        cmax=max(cmax,i+nums[i]);
        if(i==cend){
            ans++;
            cend=cmax;
        }
    }
    return ans;
}



// // not worked
// // O(n)
// int jump_02(vector<int>& nums) 
// {
//     int i=0;
//     int ans=0;
//     while(i<nums.size())
//     {
//         if(i==nums.size()-1)
//             return ans;
//         int m=i;
//         int mj=-1;
//         for(int j=i+1;j<=i+nums[i] && j<nums.size();j++)
//         {
//             if(j+nums[j] > m)
//             {
//                 m=j+nums[j];
//                 mj=j;
//             }
//         }
//         ans++;
//         i=mj;
//     }
//     return ans;
// }

int main(int args,char** argv)
{
    vector<int> arr={1,2,3};
    // vector<int> arr={3,0,2,1,2,0,4,0,0,2};
    // vector<int> arr={2,2,3,10,1,1,1,1};
    // cout<<jump(arr)<<endl;
    cout<<jump_02(arr)<<endl;
    return 0;
}