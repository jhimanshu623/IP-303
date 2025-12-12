class Solution {
    public int findPivot(int[] nums)
    {
        int l=0;
        int h=nums.length-1;
        while(l<h)
        {
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[h])
                l=mid+1;
            else
                h=mid;
        }
        return l;
    }
    public int binarySearch(int[] nums,int t,int l,int h)
    {
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(nums[mid]==t)
                return mid;
            else if(nums[mid]<t)
                l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }
    public int search(int[] nums, int t) {
        int pidx=findPivot(nums);
        int res1=binarySearch(nums,t,pidx,nums.length-1);
        if(res1!=-1)
            return res1;
        int res2=binarySearch(nums,t,0,pidx-1);
        return res2;
    }
}

// alternative

class Solution {
    public int search(int[] nums, int t) {
        int l=0;
        int h=nums.length-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(nums[mid]==t)
                return mid;
            else if(nums[mid]>nums[h])
            {
                if(t>=nums[l] && t<nums[mid])
                    h=mid-1;
                else
                    l=mid+1;
            }
            else
            {
                if(t>nums[mid] && t<=nums[h])
                    l=mid+1;
                else 
                    h=mid-1;       
            }
        }
        return -1;
    }
}