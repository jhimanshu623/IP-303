// O(nlogn)
import java.util.Arrays;

public class p2 {
    public static int lengthOfLIS(int[] nums) {
        int ans=0;
        int[] minVal=new int[nums.length];
        String[] lis=new String[nums.length];
        Arrays.fill(lis,"");
        for(int val:nums)
        {
            int l=0;
            int h=ans;
            while(l<h)
            {
                int mid=(l+h)/2;
                if(minVal[mid] < val)
                    l=mid+1;
                else
                    h=mid;
            }
            minVal[l]=val;
            if(l==ans){
                ans++;
            }
            if(l>0)
                lis[l]=(lis[l-1] + val + " ");
            else
                lis[l]=val+" ";
        }
        System.out.println(lis[ans-1]);
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={-4,-1,0,6,9,7,1,12,10,11,2,3,18,4,5};
        System.out.println(lengthOfLIS(nums));
    }
}