#include<iostream>
#include<vector>
using namespace std;


void wiggleSort(vector<int> &nums) {
    if(nums.size()==0)
        return;
    for(int i=0;i<nums.size()-1;i++)
    {
        if(i%2!=0)
        {
            if(nums[i]<nums[i+1])
                swap(nums[i],nums[i+1]);
        }
        else
        {
            if(nums[i]>nums[i+1])
                swap(nums[i],nums[i+1]);
        }
    }
}

// void wiggleSort(vector<int> &arr) {
//     for(int i=0;i<arr.size();i++)
//     {
//         if(i%2!=0)
//         {
//             if(arr[i]<arr[i-1])
//                 swap(arr[i],arr[i-1]);
//         }
//         else
//         {
//             if(i!=0 && arr[i]>arr[i-1])
//                 swap(arr[i],arr[i-1]);
//         }
//     }
// }

int main(int args,char** argv)
{
    vector<int> arr={3,5,2,1,6,4};
    wiggleSort(arr);
    for(int i:arr)
        cout<<i<<"  ";
    cout<<endl;
    return 0;
}