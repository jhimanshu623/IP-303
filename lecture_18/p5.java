package lecture_18;

public class p5 {
    public static int[] productExceptSelf(int[] arr) {
        int out[]=new int[arr.length];
        out[0]=arr[0];
        for(int i=1;i<arr.length;i++)
            out[i]=arr[i]*out[i-1];
        int suf=1;
        for(int i=arr.length-1;i>=0;i--)
        {
            if(i-1>=0)
                out[i]=suf*out[i-1];
            else
                out[i]=suf;
            suf=suf*arr[i];
        }
        return out;
    }    
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        System.out.println(productExceptSelf(arr));
    }    
}