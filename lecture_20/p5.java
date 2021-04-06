package lecture_20;

public class p5 {
    public static int majorityElement(int[] arr) {
        if(arr.length==0)
            return -1;
        int val=arr[0];
        int count=1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==val)
                count++;
            else
            {
                if(count==0)
                {
                    val=arr[i];
                    count=1;
                }
                else
                    count--;
            }
        }
        if(count==0)
            return -1;
        count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==val)
                count++;
        }
        return (count>arr.length/2)?val:-1;
    }
    public static void main(String[] args) {
        int arr[]={2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}