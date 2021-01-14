// https://www.geeksforgeeks.org/temple-offerings/
// https://leetcode.com/problems/candy/

public class p2 {
    public static int templeOfferings(int[] arr) {
        int left[]=new int[arr.length];
        int right[]=new int[arr.length];
        left[0]=1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>arr[i-1])
                left[i]=left[i-1]+1;
            else
                left[i]=1;
        }
        right[arr.length-1]=1;
        for(int i=arr.length-2;i>=0;i--)
        {
            if(arr[i]>arr[i+1])
                right[i]=right[i+1]+1;
            else
                right[i]=1;
        }
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            ans+=Math.max(left[i],right[i]);
        }
        return ans;
    }

    public static int templeOfferings_02(int[] arr) {
        int strg[]=new int[arr.length];
        Arrays.fill(strg,1);
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>arr[i-1])
                strg[i]=strg[i-1]+1;
        }
        int sum=strg[strg.length-1];
        for(int i=strg.length-2;i>=0;i--)
        {
            if(arr[i]>arr[i+1])
            {
                strg[i]=Math.max(strg[i],strg[i+1]+1);
            }
            sum+=strg[i];
        }
        return sum;
    }

    // more optimized
    public static int templeOfferings_03(int[] ratings) {
        if (ratings.Length == 0) return 0;
        int ret = 1;
        int up = 0, down = 0, peak = 0;
        for (int i = 1; i < ratings.Length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                peak = ++up;
                down = 0;
                ret += 1 + up;
            } else if (ratings[i - 1] == ratings[i])  {
                peak = up = down = 0;
                ret += 1;
            } else {
                up = 0;
                down++;
                ret += 1 + down + (peak >= down ? -1 : 0);
            }
        }
        return ret;
    }

    public static void main(String args[])
    {
        int arr[]={1, 4, 3, 6, 2, 1};
        System.out.println(templeOfferings(arr));
        System.out.println(templeOfferings_02(arr));
        System.out.println(templeOfferings_03(arr));
    }
}