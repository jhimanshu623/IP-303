package lecture_20;

public class p9 {
    public static int maxChunksToSorted(int[] arr) {
        int max[]=new int[arr.length];
        int min;
        max[0]=arr[0];
        min=arr[arr.length-1];
        for(int i=1;i<arr.length;i++)
            max[i]=Math.max(max[i-1],arr[i]);
        int count=0;
        for(int i=arr.length-2;i>=0;i--)
        {
            if(max[i]<min)
                count++;
            min=Math.min(min,arr[i]);
        }
        return count+1;
    }
    public static void main(String[] args) {
        int arr[]={18,12,16,22,20,24,30,28};
        System.out.println(maxChunksToSorted(arr));
    }    
}