import java.util.ArrayList;

public class p5 {
    static ArrayList<Integer>[] g;
    static boolean[] vis;
    static int[] disc;
    static int[] low;
    static int os;
    static int children=0;
    static int ap=0; //articulation point
    static int counter=0;
    public static void addEdge(int u,int v)
    {
        g[u].add(v);
        g[v].add(u);
    }
    public static void display()
    {
        for(int i=0;i<g.length;i++)
        {
            System.out.print(i+" -> ");
            for(int n=0;n<g[i].size();n++)
            {
                int nv=g[i].get(n);
                System.out.print(nv+", ");
            }
            System.out.println();
        }
    }
    public static void dfs(int s,int par)
    {
        vis[s]=true;
        disc[s]=counter;
        low[s]=counter;
        counter++;
        boolean flag=false;
        for(int n=0;n<g[s].size();n++)
        {
            int nv=g[s].get(n);
            if(nv==par)
                continue;
            else if(vis[nv]==true)
                low[s]=Math.min(low[s],disc[nv]);
            else
            {
                if(s==os)
                    children++;
                dfs(nv,s);
                low[s]=Math.min(low[s],low[nv]);
                if(disc[s]<=low[nv] && s!=os){
                    // System.out.println("ap:  "+s);
                    if(flag==false){
                        ap++;
                        flag=true;
                    }
                }
            }
        }
    } 
    public static int articulationPoints()
    {
        int n=g.length;
        disc=new int[n];
        low=new int[n];
        vis=new boolean[n];
        os=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==false)
            {
                dfs(i,-1);
            }
        }
        if(children>=2)
            ap++;
        return ap;
    }
    public static void main(String[] args) {
        g=new ArrayList[8];
        for(int i=0;i<g.length;i++)
            g[i]=new ArrayList<Integer>();
        addEdge(0,1);
        addEdge(1,2);
        addEdge(2,3);
        addEdge(3,0);
        addEdge(3,4);
        addEdge(4,5);
        addEdge(5,6);
        addEdge(5,7);
        addEdge(6,7);

        // addEdge(0,1);
        // addEdge(1,2);
        // addEdge(2,3);


        // addEdge(0, 1); 
        // addEdge(1, 2); 
        // addEdge(2, 0); 
        // addEdge(1, 3); 
        // addEdge(1, 4); 
        // addEdge(1, 6); 
        // addEdge(3, 5); 
        // addEdge(4, 5);
        // display();
        System.out.println(articulationPoints());
    }
}