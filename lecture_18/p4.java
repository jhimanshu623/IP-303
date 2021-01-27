package lecture_18;

public class p4 {
    public static int removeDuplicates(int[] arr) {
        int j=1;
        int i=1;
        while(i<arr.length)
        {
            if(arr[i]==arr[i-1])
                i++;
            else
            {
                arr[j]=arr[i];
                j++;
                i++;
            }
        }
        return j;
    }
    public static void main(String[] args) {
        int arr[]={1,1,1,2,2,2,2,3,3,3,4,4,4,4,4};
        System.out.println(removeDuplicates(arr));
    }    
}