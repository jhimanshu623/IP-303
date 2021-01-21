import java.util.HashMap;
public class p1
{
    // 2ms
    public static int numRabbits(int[] arr) {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:arr)
            map.put(val,map.getOrDefault(val,0)+1);
        for(int val:map.keySet())
        {
            int grp_size=val+1;
            int rab=map.get(val);
            ans+=grp_size*Math.ceil(rab*1.0/grp_size);
        }
        return ans;
    }
    // 0ms
    public static int numRabbits_02(int[] answers) {
        int c[] = new int[1000], res = 0;
        for (int i : answers){
            if (c[i] % (i + 1) == 0)
                res += i + 1;
            c[i]++;
        }
        return res;
    }
    public static void main(String args[])
    {
        int arr[]={4,4,4,2,2,2,5,5,3,3,3,3,3};
        System.out.println(numRabbits(arr));
        System.out.println(numRabbits_02(arr));
    }
}