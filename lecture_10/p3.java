import java.util.HashMap;
public class p3 {
    public static int subarraySum(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int ps=0;
        map.put(ps,1);
        for(int i=0;i<arr.length;i++)
        {
            ps+=arr[i];
            ans+=map.getOrDefault(ps-k,0);
            map.put(ps,map.getOrDefault(ps, 0)+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={2,3,-1,4,-5,1,6,-4,3,-1,4};
        int k=4;
        System.out.println(subarraySum(arr,k));
    }
}