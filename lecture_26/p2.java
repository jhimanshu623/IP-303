import java.util.Arrays;

public class p2 {
    static class Pair implements Comparable<Pair>
    {
        int p;
        int s;
        double t;
        Pair(int p,int s,int target)
        {
            this.p=p;
            this.s=s;
            this.t=(target-p)/(s*1.0);
        }
        public int compareTo(Pair p)
        {
            return this.p-p.p;
        }
    }
    public static int carFleet(int t, int[] pos, int[] speed) {
        Pair[] cars=new Pair[pos.length];
        for(int i=0;i<pos.length;i++)
        {
            cars[i]=new Pair(pos[i],speed[i],t);
        }
        Arrays.sort(cars);
        int i=cars.length-1;
        double min_time=0;
        int ans=0;
        while(i>=0)
        {
            if(cars[i].t>min_time)
            {
                ans++;
                min_time=cars[i].t;
            }
            i--;
        }
        return ans;
    }
    public static void main(String[] args) {
        int t=12;
        int pos[]={10,8,0,5,3};
        int speed[]={2,4,1,1,3};
        System.out.println(carFleet(t, pos, speed));
    }
}