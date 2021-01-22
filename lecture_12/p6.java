public class Solution {
    /**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public int[] anagramMappings(int[] a, int[] b) {
        int[] ans=new int[a.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<b.length;i++)
            map.put(b[i],i);
        for(int i=0;i<a.length;i++)
        {
            ans[i]=map.get(a[i]);
        }
        return ans;
    }
}