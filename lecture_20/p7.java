package lecture_20;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class p7 {
    public static ArrayList<Integer> majorityElement(int arr[],int k)
    {
        ArrayList<Integer> res=new ArrayList<>();
        if(arr.length==0)
            return res;
        int val[]=new int[k-1];
        int count[]=new int[k-1];
        Arrays.fill(val,arr[0]);
        val[0]=arr[0];
        count[0]=1;
        for(int i=1;i<arr.length;i++)
        {
            int j;
            for(j=0;j<k-1;j++)
            {
                if(arr[i]==val[j]){
                    count[j]++;
                    break;
                }
            }
            if(j<k-1)
                continue;
            for(j=0;j<k-1;j++)
            {
                if(count[j]==0){
                    val[j]=arr[i];
                    count[j]=1;
                    break;
                }
            }
            if(j<k-1)
                continue;
            for(j=0;j<k-1;j++)
                count[j]--;
        }
        Arrays.fill(count,0);
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<k-1;j++)
            {
                if(arr[i]==val[j]){
                    count[j]++;
                    break;
                }
            }
        }
        for(int j=0;j<k-1;j++)
        {
            if(count[j]>arr.length/k)
                res.add(val[j]);
        }
        return res;
    }

    public static ArrayList<Integer> majorityElement2(int arr[],int k)
    {
        ArrayList<Integer> res=new ArrayList<>();
        if(arr.length==0)
            return res;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr)
            map.put(i,map.getOrDefault(i,0)+1);
        for(int val:map.keySet())
        {
            if(map.get(val)>arr.length/k)
                res.add(val);
        }
        return res;
    }


    public static void main(String[] args) {
        int arr[]={3, 1, 2, 2, 1, 2, 3, 3};
        // int arr[]={2,4,3,2,3,3,4,2,2,4,4};
        int k=4;
        ArrayList<Integer> res=majorityElement(arr,k);
        for(int i:res)
            System.out.print(i+" ");
        System.out.println();
        ArrayList<Integer> res2=majorityElement2(arr,k);
        for(int i:res2)
            System.out.print(i+" ");
    }
}