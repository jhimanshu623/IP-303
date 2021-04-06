package lecture_20;

import java.util.Arrays;
import java.util.HashMap;

public class p2
{
    // O(nlogn)
    public static boolean twoSum(int arr[],int ts)
    {
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while(i<j)
        {
            if(arr[i]+arr[j]==ts)
                return true;
            else if(arr[i]+arr[j]<ts)
                i++;
            else
                j--;
        }
        return false;
    }

    //O(n) 
    public static boolean twoSum2(int arr[],int ts)
    {
        HashSet<Integer> set=new HashSet<>();
        for(int i:arr)
        {
            if(set.contains(ts-i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static boolean twoSum3(int arr[],int ts)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:arr)
            map.put(val,map.getOrDefault(val, 0)+1);
        for(int i:arr)
        {
            if(map.containsKey(ts-i)){
                if(i!=ts-i || map.get(ts-i)>=2)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[]={1, 2, 5, 6, 7};
        int ts=4;
        System.out.println(twoSum(arr,ts));
        System.out.println(twoSum2(arr,ts));
    }
}