import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;
public class p1
{
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
    public static void addEdge(ArrayList<Edge>[] graph,int u,int v)
    {
        graph[u-1].add(new Edge(v-1,0));
        graph[v-1].add(new Edge(u-1,1));
    }
    static class DPair implements Comparable<DPair>
    {
        int v;
        int c;
        DPair(int v,int c)
        {
            this.v=v;
            this.c=c;
        }
        public int compareTo(DPair other)
        {
            return this.c-other.c;
        }
    }
    public static void chefAndReverse(ArrayList<Edge>[] graph,int s,int d)
    {
        PriorityQueue<DPair> pq=new PriorityQueue<>();
        pq.add(new DPair(s, 0));
        boolean visited[]=new boolean[graph.length];
        while(pq.size()>0)
        {
            DPair rp=pq.remove();
            if(visited[rp.v]==true)
                continue;
            if(rp.v==d){
                System.out.println(rp.c);
                return;
            }
            visited[rp.v]=true;
            for(int n=0;n<graph[rp.v].size();n++)
            {   
                Edge e=graph[rp.v].get(n);
                if(visited[e.v]==false)
                    pq.add(new DPair(e.v, rp.c+e.wt));
            }
        }
        System.out.println(-1);
    }
    
    // 01 bfs coorect solution
    
    static class DPair
    {
        int v;
        int c;
        DPair(int v,int c)
        {
            this.v=v;
            this.c=c;
        }
    }
    
    public static void chefAndReverse_0_1_bfs(ArrayList<Edge>[] graph,int s,int d)
    {
        LinkedList<DPair> que=new LinkedList<>();
        que.add(new DPair(s, 0));
        boolean visited[]=new boolean[graph.length];
        while(que.size()>0)
        {
            DPair rp=que.removeFirst();
            if(visited[rp.v]==true)
                continue;
            if(rp.v==d){
                System.out.println(rp.c);
                return;
            }
            visited[rp.v]=true;
            for(int n=0;n<graph[rp.v].size();n++)
            {   
                Edge e=graph[rp.v].get(n);
                if(visited[e.v]==false){
                    if(rp.c == rp.c+e.wt)
                        que.addFirst(new DPair(e.v, rp.c+e.wt));
                    else    
                        que.addLast(new DPair(e.v, rp.c+e.wt));
                }
            }
        }
        System.out.println(-1);
    }
	public static void main (String[] args)
	{
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int m=sc.nextInt();
	    ArrayList<Edge>[] graph=new ArrayList[n];
	    for(int i=0;i<n;i++)
	        graph[i]=new ArrayList<Edge>();
	    int t=m;
	    while(t-->0)
	    {
	        int u=sc.nextInt();
	        int v=sc.nextInt();
	        addEdge(graph,u,v);
        }
        // display(graph);
        chefAndReverse(graph,0,n-1);
	}
}