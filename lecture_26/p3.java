import java.util.ArrayList;

public class p3 {
    public static int[] firstNegative(int[]arr ,int k)
    {
        int[] res=new int[arr.length-k+1];
        int n=-1;
        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]<0){
                if(i<=res.length-1)
                    res[i]=arr[i];
                n=i;
            }
            else
            {
                if(n>=0 && n<=i+k-1)
                {
                    if(i<=res.length-1)
                        res[i]=arr[n];
                }
                else
                {
                    if(i<=res.length-1)
                        res[i]=0;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={12, -1, -7, 8, -15, 30, 16, 28};
        int k=3;
        int[] res=firstNegative(arr,k);
        for(int i:res)
            System.out.print(i+" ");
        System.out.println();
    }    
}