package lecture_20;

public class p8 { 
    public static int maxChunksToSorted(int arr[])
    {
        int c_max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            c_max=Math.max(c_max,arr[i]);
            if(i==c_max)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[]={1,2,0,3,5,7,4,6};
        System.out.println(maxChunksToSorted(arr));
    }
}