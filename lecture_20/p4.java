package lecture_20;

import java.util.Arrays;

public class p4
{
    public static int numRescueBoats(int[] arr, int l) {
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        int ans=0;
        while(i<=j)
        {
            if(arr[i]+arr[j]>l)
            {
                ans++;
                j--;
            }
            else
            {
                ans++;
                i++;
                j--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={3,5,3,4};
        int limit=5;
        System.out.println(numRescueBoats(arr,limit));
    }
}