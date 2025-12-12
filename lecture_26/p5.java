public class p5 {
    public static long maxSum(long arr[])
    {
        long ans=Long.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++)
            ans=Math.max(ans,arr[i]+arr[i+1]);
        return ans;
    }
    public static void main(String[] args) {
        long arr[]={4,7,1,5,6};
        System.out.println(maxSum(arr));
    }    
}