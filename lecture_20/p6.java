package lecture_20;
import java.util.ArrayList;
import java.util.List;

public class p6 {
    public static List<Integer> majorityElement(int[] arr) {
        List<Integer> res=new ArrayList<>();
        if(arr.length<2)
        {
            for(int i=0;i<arr.length;i++)
                res.add(arr[i]);
            return res;
        }
        int val1=arr[0];
        int count1=1;
        int val2=arr[0];
        int count2=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==val1)
                count1++;
            else if(arr[i]==val2)
                count2++;
            else if(count1==0)
            {
                val1=arr[i];
                count1=1;
            }
            else if(count2==0)
            {
                val2=arr[i];
                count2=1;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==val1)
                count1++;
            else if(arr[i]==val2)
                count2++;
        }
        if(count1>arr.length/3)
            res.add(val1);
        if(count2>arr.length/3)
            res.add(val2);
        return res;
    }
    public static void main(String[] args) {
        int arr[]={2,4,3,2,3,3,4,2,2,4,4};
        List<Integer> res=majorityElement(arr);
        for(int i:res)
            System.out.print(i+" ");
    }
}