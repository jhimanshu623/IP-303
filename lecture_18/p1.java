package lecture_18;

public class p1 {
    public static int maxSubArray(int[] nums) {
        int cmax=Integer.MIN_VALUE;
        int omax=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(cmax>=0)
                cmax=cmax+nums[i];
            else
                cmax=nums[i];
            if(cmax>omax)
                omax=cmax;
        }
        return omax;
    }
    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }    
}