import java.util.*;

public class p5
{
    static void dfs(ArrayList<ArrayList<Integer>> g,int s,boolean[] visited,Stack<Integer> st)
    {
        visited[s]=true;
        for(int n=0;n<g.get(s).size();n++)
        {
            int nv=g.get(s).get(n);
            if(visited[nv]==false)
                dfs(g,nv,visited,st);
        }
        st.push(s);
    }
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean[] visited=new boolean[n];
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
                dfs(adj,i,visited,st);
        }
        while(st.size()>0)
        {
            res[n-st.size()]=st.pop();
        }
        return res;
    }
    public static void main(String args[])
    {

    }
}