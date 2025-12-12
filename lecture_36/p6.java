import java.util.*;

public class p6 {
    static void dfs(ArrayList<ArrayList<Integer>> g,int s,boolean[] visited,int[] indegree)
    {
        visited[s]=true;
        for(int n=0;n<g.get(s).size();n++)
        {
            int nv=g.get(s).get(n);
            indegree[nv]++;
            if(visited[nv]==false)
                dfs(g,nv,visited,indegree);
        }
    }
    static int[] topoSort(ArrayList<ArrayList<Integer>> g, int n) {
        boolean[] visited=new boolean[n];
        int[] indegree=new int[n];
        int[] res=new int[n];
        LinkedList<Integer> que=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
                dfs(g,i,visited,indegree);
        }
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
                que.addLast(i);
        }
        int ri=0;
        while(que.size()>0)
        {
            int v=que.removeFirst();
            res[ri++]=v;
            for(int nbr=0;nbr<g.get(v).size();nbr++)
            {
                int nv=g.get(v).get(nbr);
                indegree[nv]--;
                if(indegree[nv]==0)
                    que.addLast(nv);
            }   
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
}