public class p7 {

    // O(n2) 
    // limited to positive integers
    public static int maxSumAlternating(int[] nums)
    {
        int[] inc=new int[nums.length];
        int[] dec=new int[nums.length];
        int ans=0;
        boolean flag=false;
        for(int i=0;i<nums.length;i++)
        {
            // inc[i]=nums[i];
            // dec[i]=nums[i];             //use if sequence is not starting from start 
            for(int j=0;j<i;j++)
            {
                if(flag==true && nums[j]<nums[i])
                    inc[i]=Math.max(inc[i] ,dec[j]+nums[i]);
                else if(nums[j]>nums[i]){
                    dec[i]=Math.max(dec[i] ,inc[j]+nums[i]);
                    flag=true;
                }
            }
            ans=Math.max(ans,Math.max(inc[i],dec[i]));
        }
        for(int i:inc)
            System.out.print(i+" ");
        System.out.println();
        for(int i:dec)
            System.out.print(i+" ");
        System.out.println();
        return ans;
    }

    public static void main(String args[])
    {
        // int[] nums={4, 8, 2, 5, 6, 8};
        int[] nums={4, 3, 8, 5, 3, 8} ;

        System.out.println(maxSumAlternating(nums));
    }
}