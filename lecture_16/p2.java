package lecture_16;

import java.util.HashMap;

public class p2
{
    public static int noPairs(int arr[][])
    {
        int ans=0;
        HashMap<Integer,Integer> xmap=new HashMap<>();
        HashMap<Integer,Integer> ymap=new HashMap<>();
        HashMap<String,Integer> xymap=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            int x=arr[i][0];
            int y=arr[i][1];
            if(xmap.containsKey(x))
                ans+=xmap.get(x);
            xmap.put(x,xmap.getOrDefault(x,0)+1);
            if(ymap.containsKey(y))
                ans+=ymap.get(y);
            ymap.put(y,ymap.getOrDefault(y,0)+1);
            String xy=x+"*"+y;
            if(xymap.containsKey(xy))
                ans-=2*xymap.get(xy);
            xymap.put(xy,xymap.getOrDefault(xy,0)+1);
        }
        return ans;
    }
    public static void main(String args[])
    {
        int arr[][]={
            {1,4},
            {2,4},
            {1,3},
            {2,3},
            {1,4},
            {5,4},
            {1,4}
        };
        System.out.println(noPairs(arr));
    }
}