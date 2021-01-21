import java.util.*;
public class p5 {
    static class Pair implements Comparable<Pair>
    {
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Pair o)
        {
            return (o.x*o.x + o.y*o.y) - (this.x*this.x + this.y*this.y);
        }
    }
    // 28ms
    // O(nlogk)
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++)
        {
            pq.add(new Pair(points[i][0],points[i][1]));
        }
        for(int i=k;i<points.length;i++)
        {
            int nv=points[i][0]*points[i][0] + points[i][1]*points[i][1];
            Pair tp=pq.peek();
            if(tp.x*tp.x+tp.y*tp.y > nv)
            {
                pq.poll();
                pq.add(new Pair(points[i][0],points[i][1]));
            }
        }
        int res[][]=new int[k][2];
        int i=0;
        while(pq.size()>0)
        {
            Pair rem=pq.poll();
            res[i][0]=rem.x;
            res[i][1]=rem.y;
            i++;
        }
        return res;
    }

    // partitioning
    // 7ms
    // average O(n)
    // worst case O(n2)
    public static int[][] kClosest_02(int[][] points, int k)
    {
        int res[][]=new int[k][2];
        int kthidx=partition(points,0,points.length-1,k-1);
        for(int i=0;i<=kthidx;i++)
            res[i]=points[i];
        return res;
    }
    public static int partition(int points[][],int s,int e,int k)
    {
        while(s<=e)
        {
            int pivot=points[e][0]*points[e][0]+points[e][1]*points[e][1];
            int pi=s;
            int i=s;
            while(i<=e)
            {
                if( (points[i][0]*points[i][0]+points[i][1]*points[i][1]) <= pivot)
                {
                    int temp[]=points[i];
                    points[i]=points[pi];
                    points[pi]=temp;
                    pi++;
                }
                i++;
            }
            pi--;
            if(pi==k)
                return pi;
            else if(pi<k)
                s=pi+1;
            else
                e=pi-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int points[][]={
            {3,3},
            {5,-1},
            {-2,4},
            {3,3}
        };
        int k=3;
        int res[][]=new int[k][2];
        res=kClosest_02(points,k);
        for(int ar[]:res)
        {
            for(int i:ar)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}