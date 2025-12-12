import java.util.*;
class Solution {
    ArrayList<Integer>[] g;
    boolean[] visited;
    Stack<Integer> st;
    public void addEdge(int u,int v)
    {
        g[u].add(v);
    }
    public boolean dfs(int s,boolean[] lv)
    {       
        visited[s]=true;
        lv[s]=true;
        for(int n=0;n<g[s].size();n++)
        {
            int nv=g[s].get(n);
            if(lv[nv]==true)
                return false;
            if(visited[nv]==false){
                boolean r=dfs(nv,lv);
                if(r==false)
                    return false;
            }
        }
        lv[s]=false;
        st.push(s);
        return true;
    }
    public int[] findOrder(int n, int[][] pr) {
        g=new ArrayList[n];
        for(int i=0;i<n;i++)
            g[i]=new ArrayList<>();
        visited=new boolean[n];
        st=new Stack<>();
        int[] res=new int[n];
        for(int i=0;i<pr.length;i++)
        {
            int u=pr[i][0];
            int v=pr[i][1];
            addEdge(v,u);
        }
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false){
                boolean[] lv=new boolean[n];
                boolean rs=dfs(i,lv);
                if(rs==false)
                {
                    return new int[0];
                }
            }   
        }
        while(st.size()>0)
        {
            res[n-st.size()]=st.pop();
        }
        return res;
    }
}