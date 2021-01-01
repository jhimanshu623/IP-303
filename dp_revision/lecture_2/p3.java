import java.util.*;

public class p3 {   
    static class Pair implements Comparable<Pair>
    {
        int n;
        int s;
        Pair(int n,int s)
        {
            this.n=n;
            this.s=s;
        }
        public int compareTo(Pair other)
        {
            if(this.n == other.n)
                return this.s - other.s;
            return this.n - other.n;
        }
    }
    public static int lis(Pair[] bridges)
    {
        int[] minVal=new int[bridges.length];
        int ans=0;
        for(int i=0;i<bridges.length;i++)
        {
            int val=bridges[i].s;
            int l=0;
            int h=ans;
            while(l<h)
            {
                int mid=(l+h)/2;
                if(minVal[mid] <= val)
                    l=mid+1;
                else
                    h=mid;
            }
            minVal[l]=val;
            if(l==ans)
                ans++;
        }
        return ans;
    }
    public static int buildingBridges(int[] north,int[] south)
    {
        Pair[] bridges=new Pair[north.length];
        for(int i=0;i<north.length;i++)
        {
            bridges[i]=new Pair(north[i],south[i]);
        }
        Arrays.sort(bridges);
        return lis(bridges);
    }
    public static void main(String args[])
    {
        int[] north={8,1,4,3,5,2,6,7};
        int[] south={1,2,3,4,5,6,7,8};
        System.out.println(buildingBridges(north,south));
    }
}