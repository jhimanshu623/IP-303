import java.util.HashMap;

public class p7
{
    public static int countSub(int arr[])
    {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int c0=0;
        int c1=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
                c0++;
            else
                c1++;
            ans+=map.getOrDefault(c1-c0, 0);
            map.put(c1-c0,map.getOrDefault(c1-c0, 0)+1);
        }
        return ans;
    }
    public static int countSub_02(int arr[])
    {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
                arr[i]=-1;
        }
        int ps=0;
        map.put(ps,1);
        for(int i=0;i<arr.length;i++)
        {
            ps+=arr[i];
            ans+=map.getOrDefault(ps-0,0);
            map.put(ps,map.getOrDefault(ps,0)+1);
        }
        return ans;
    }
    public static void main(String args[])
    {
       int arr[]={1,0,0,1,0,1,1};
       System.out.println(countSub(arr));
       System.out.println(countSub_02(arr));
    }
}