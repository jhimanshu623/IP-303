import java.util.HashMap;

public class p4 {
    public static int countSubK(int arr[],int k)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ps=0;
        int ans=0;
        map.put(ps,1);
        for(int i=0;i<arr.length;i++)
        {
            ps=ps+arr[i];
            int rem=ps%k;
            if(rem<0)
                rem=rem+k;
            ans+=map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem,0)+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={2,3,1,7,4,-18,6,3,4,-14,2,9};
        int k=5;
        System.out.println(countSubK(arr,k));
    }
}