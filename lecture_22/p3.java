
public class p3 {
    public static int maxProduct(int[] nums) {
        if(nums.length==0)
            return 0;
        int pp=nums[0];
        int np=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                pp=Math.max(nums[i],nums[i]*pp);
                np=Math.min(nums[i],nums[i]*np);
                
            }
            else
            {
                int temp=pp;
                pp=Math.max(nums[i],nums[i]*np);
                np=Math.min(nums[i],nums[i]*temp);
            }
            ans=Math.max(ans,pp);
        }
        return ans;
    }
    public static int maxProduct2(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int prefix_prod=1;
        int suffix_prod=1;
        boolean flag=false;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0){
                prefix_prod=1;
                flag=true;
            }
            else{
                prefix_prod*=nums[i];
                ans=Math.max(ans,prefix_prod);
            }
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]==0){
                suffix_prod=1;
                flag=true;
            }
            else{
                suffix_prod*=nums[i];
                ans=Math.max(ans,suffix_prod);
            }
        }
        if(flag==true)
            ans=Math.max(ans,0);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={2,3,-2,4};
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct2(nums));
    }    
}