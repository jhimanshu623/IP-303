import java.util.*;

public class p3 {
    static class Edge
    {
        int v;
        int wt;
        Edge(int v,int wt)
        {
            this.v=v;
            this.wt=wt;
        }
    }
    public static void addEdge(ArrayList<Edge>[] graph,int u,int v,int c)
    {
        graph[u].add(new Edge(v,c));
        graph[v].add(new Edge(u,c));
    }
    public static void  display(ArrayList<Edge>[] g)
    {
        for(int nbr=0;nbr<g.length;nbr++)
        {
            System.out.print(nbr+" -> :");
            for(int e=0;e<g[nbr].size();e++)
            {
                Edge ee=g[nbr].get(e);
                System.out.print("[ "+ee.v+", "+ee.wt+"], ");
            }
            System.out.println();
        }
        System.out.println();
    }
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
    public static int prims(ArrayList<Edge>[] graph)
    {
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
            for(int n=0;n<graph[rp.v].size();n++)
            {
                Edge e=graph[rp.v].get(n);
                if(visited[e.v]==false)
                {
                    PPair np=new PPair(e.v,e.wt);
                    pq.add(np);
                }
            }
        }
        return ans;
    }
    public static int optimizeWater(int n,int[] wells,int[][] pipes)
    {
	    ArrayList<Edge>[] graph=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
	        graph[i]=new ArrayList<Edge>();
        for(int i=0;i<wells.length;i++)
            addEdge(graph, 0, i+1, wells[i]);
        for(int i=0;i<pipes.length;i++)
            addEdge(graph, pipes[i][0], pipes[i][1], pipes[i][2]);
        return prims(graph);
    }
    public static void main(String[] args) {
        int n = 3;
        int[] wells = {1,2,2};
        int[][] pipes = {
            {1,2,1},
            {2,3,1}
        };
        System.out.println(optimizeWater(n,wells,pipes));
    }
}