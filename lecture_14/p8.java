class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] lmax=new int[nums.length];
        int[] rmax=new int[nums.length];
        lmax[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(i%k==0)
                lmax[i]=nums[i];
            else
                lmax[i]=Math.max(lmax[i-1],nums[i]);
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            if(i==nums.length-1 || (i+1)%k==0)
                rmax[i]=nums[i];
            else
                rmax[i]=Math.max(rmax[i+1],nums[i]);
        }
        int[] res=new int[nums.length-k+1];
        for(int i=0;i<res.length;i++)
        {
            res[i]=Math.max(rmax[i],lmax[i+k-1]);
        }
        return res;
    }
}