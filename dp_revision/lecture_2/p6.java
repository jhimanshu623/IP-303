public class p6
{
    public static int lds(int[] nums)
    {
        int[] maxVal=new int[nums.length];
        int ans=0;
        for(int val:nums)
        {
            int l=0;
            int h=ans;
            while(l<h)
            {
                int mid=(l+h)/2;
                if(maxVal[mid] > val)
                    l=mid+1;
                else
                    h=mid; 
            }
            maxVal[l]=val;
            if(l==ans)
                ans++;
        }
        return ans;
    }
    
    public static void main(String args[])
    {
        int[] nums={1,6,2,4,3};
        System.out.println(lds(nums));
    }
}