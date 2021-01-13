
public class p5 {
    public static int maxSum(int arr[])
    {
        int in=0;
        int ex=0;
        for(int i=0;i<arr.length;i++)
        {
            int nin=arr[i]+ex;
            int nex=Math.max(in,ex);
            in=nin;
            ex=nex;
        }
        return Math.max(in,ex) ;
    }
    public static void main(String[] args) {
        int arr[]={5, 5, 10, 100, 10, 5};
        System.out.println(maxSum(arr));
    }
}