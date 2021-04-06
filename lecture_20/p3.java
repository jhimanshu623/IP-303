package lecture_20;

import java.util.HashMap;
import java.util.Arrays;

public class p3
{
    // O(nlogn)
    public static int twoDiff(int arr[],int td)
    {
        Arrays.sort(arr);
        int i=0;
        int j=0;
        while(j<arr.length)
        {
            if(i==j)
                j++;
            else if(arr[j]-arr[i]==td)
                return 1;
            else if(arr[j]-arr[i]<td)
                j++;
            else
                i++;
        }
        return -1;
    }
    // O(n)
    public static int twoDiff2(int arr[],int ts)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:arr)
            map.put(val,map.getOrDefault(val, 0)+1);
        for(int i:arr)
        {
            if(ts==0 && map.get(i)>=2)
                return 1;
            else if(ts!=0 && map.containsKey(ts+i)){
                    return 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={5, 20, 3, 2, 5, 80};
        int td=78;
        System.out.println(twoDiff(arr, td));
        System.out.println(twoDiff2(arr, td));
    }
}