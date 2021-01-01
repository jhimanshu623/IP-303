public class p8 {

    // O(n2) 
    // limited to positive integers
    public static int maxSumAlternating(int[] nums)
    {
        int[] inc=new int[nums.length];
        int[] dec=new int[nums.length];

        int ans=0;
        // boolean flag=false;
        inc[0]=nums[0];
        dec[0]=nums[0];
        int si=nums.length;
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(j>=si && nums[j]<nums[i])
                    inc[i]=Math.max(inc[i] ,dec[j]+nums[i]);
                else if(nums[j]>nums[i]){
                    dec[i]=Math.max(dec[i] ,inc[j]+nums[i]);
                    if(si==nums.length)
                        si=i;
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
        // int[] nums={4, 3, 8, 5, 3, 8} ;
        // int[] nums={4, -3, 8, 5, 3, 8} ;
        // int[] nums={4, 8, 2, 5, 6, 8} ;
        System.out.println(maxSumAlternating(nums));
    }
}