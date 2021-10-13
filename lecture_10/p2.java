public class p2 {
    public static int max_1(int arr[])
    {
        int ans=0;
        int c=0;
        for(int i:arr)
        {
            if(i==0)
                c=0;
            else
            {
                c+=1;
                ans=Math.max(ans,c);
            }
        }
        return ans;
    }

    // for zeros or ones
    public static int solve(int arr[]){
        int c_count=1,o_count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                c_count++;
            }else{
                c_count=1;
            }
            o_count=Math.max(o_count,c_count);
        }
        return o_count;
    }
    public static void main(String[] args) {
        int arr[] ={1,1,0,0,1,1,1,1,0,0,0,1,0,1,1,1,1,1,1};
        System.out.println(max_1(arr));
    }
}