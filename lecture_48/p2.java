public class p2
{
    public static void countingSort(int[] nums)
    {
        int mv=Integer.MIN_VALUE;
        for(int i:nums)
            mv=Math.max(mv,i);
        int[] freq=new int[mv+1];
        for(int i:nums)
            freq[i]++;
        for(int i=1;i<freq.length;i++)
        {
            freq[i]=freq[i]+freq[i-1];
        }
        int[] res=new int[nums.length];
        for(int i:nums)
        {
            freq[i]--;
            res[freq[i]]=i;
        }
        
        nums=res;
        for(int i:nums)
            System.out.print(i+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        int[] nums={1,4,1,2,7,5,2};
        countingSort(nums);
        for(int i:nums)
            System.out.print(i+" ");
    }
}



