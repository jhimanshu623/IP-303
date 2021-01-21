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
    public static void main(String[] args) {
        int arr[] ={1,1,0,0,1,1,1,1,0,0,0,1,0,1,1,1,1,1,1};
        System.out.println(max_1(arr));
    }
}