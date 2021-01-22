import java.util.HashMap;

public class p3
{
    // 5ms
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int i:nums)
            map.put(i,true);
        for(int val:map.keySet())
        {
            if(map.containsKey(val-1))
                map.put(val,false);
        }
        int ans=0;
        for(int val:map.keySet())
        {
            if(map.get(val)==true)
            {
                int len=0;
                while(map.containsKey(val++))
                    len++;
                ans=Math.max(ans,len);
            }
        }
        return ans;
    }

    public static int longestConsecutive2(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int sp=-1;
        int ep=-1;
        int len=0;
        for(int val:nums)
        {
            if(map.containsKey(val))
                continue;
            if(!map.containsKey(val-1) && !map.containsKey(val+1))
            {
                sp=val;
                ep=val;
            }
            else if(map.containsKey(val-1) && !map.containsKey(val+1))
            {
                sp=val-map.get(val-1);
                ep=val;
            }
            else if(!map.containsKey(val-1) && map.containsKey(val+1))
            {
                sp=val;
                ep=val+map.get(val+1);
            }
            else if(map.containsKey(val-1) && map.containsKey(val+1))
            {
                
                sp=val-map.get(val-1);
                ep=val+map.get(val+1);
            }
            len=ep-sp+1;
            map.put(val,1);
            map.put(sp,len);
            map.put(ep,len);
            ans=Math.max(ans,len);
        }
        return ans;
    }
    public static void main(String args[])
    {
        int nums[]={1,2,3,4,9,8,7,6,5};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive2(nums));
        // {1,2,0,1};
    }
}