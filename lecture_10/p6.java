import java.util.Collections;
import java.util.PriorityQueue;

public class p6
{
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int ans=0;
        int f=startFuel;
        for(int i=0;i<stations.length;i++)
        {
            while(f<stations[i][0] && pq.size()!=0)
            {
                f+=pq.poll();
                ans++;
            }
            if(f<stations[i][0])
                return -1;
            pq.add(stations[i][1]);
        }
        while(f<target && pq.size()!=0)
        {
            f+=pq.poll();
            ans++;
        }
        return (f<target)?-1:ans;
    }

    // dp  -> O(n2)
    

    public static void main(String args[])
    {
        int target = 1000;
        int startFuel = 83;
        int stations[][] = {
            {25,27},
            {36,187},
            {140,186},
            {378,6},
            {492,202},
            {517,89},
            {579,234},
            {673,86},
            {808,53},
            {954,49}
        };
        System.out.println(minRefuelStops(target,startFuel,stations));
    }
}