import java.util.PriorityQueue;

public class p2 {
    static class PPair implements Comparable<PPair>
    {
        int v;
        int c;
        PPair(int v,int c)
        {
            this.v=v;
            this.c=c;
        }
        public int compareTo(PPair other)
        {
            return this.c-other.c;
        }
    }
    public static int minCost(int[][] graph)
    {
        if(graph.length==0)
            return 0;
        PriorityQueue<PPair> pq=new PriorityQueue<>();
        boolean[] visited=new boolean[graph.length];
        pq.add(new PPair(0,0));
        int ans=0;
        while(pq.size()>0)
        {
            PPair rp=pq.poll();
            if(visited[rp.v]==true)
                continue;
            ans+=rp.c;
            visited[rp.v]=true;
            for(int n=0;n<graph[rp.v].length;n++)
            {
                if(visited[n]==false && graph[rp.v][n]!=0)
                {
                    PPair np=new PPair(n,graph[rp.v][n]);
                    pq.add(np);
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] graph={
            {0, 1, 2, 3, 4},
            {1, 0, 5, 0, 7},
            {2, 5, 0, 6, 0},
            {3, 0, 6, 0, 0},
            {4, 7, 0, 0, 0}
        };
        System.out.println(minCost(graph));
    }
}