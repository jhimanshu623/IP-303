#include<iostream>
#include<vector>
using namespace std;

void reverse(vector<int>& nums,int s,int e)
{
    while(s<e)
    {
        swap(nums[s++],nums[e--]);
        // int t=nums[s];
        // nums[s]=nums[e];
        // nums[e]=t;
        // s++;e--;
    }
}
void rotate(vector<int>& nums, int k) {
    k=k%nums.size();
    if(k<0)
        k=nums.size()+k;
    reverse(nums,0,nums.size()-k-1);
    reverse(nums,nums.size()-k,nums.size()-1);
    reverse(nums,0,nums.size()-1);
}
int main(int args,char** argv)
{
    vector<int> nums={1,2,3,4,5,6,7};
    int k=3;
    rotate(nums,k);
    for(int i:nums)
        cout<<i<<" ";
    return 0;
}