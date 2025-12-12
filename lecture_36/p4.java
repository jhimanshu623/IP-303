import java.util.*;

class Solution {
    HashMap<String,HashMap<String,Double>> g=new HashMap<>();
    double[] res;
    HashSet<String> visited;
    int qi=0;
    public void addEdge(String u,String v,double c)
    {
        if(g.get(u)==null)
            g.put(u,new HashMap<String,Double>());
        g.get(u).put(v,c);
        if(g.get(v)==null)
            g.put(v,new HashMap<String,Double>());
        g.get(v).put(u,1/c);
    }
    public boolean dfs(String s,String d,double asf)
    {
        if(s.equals(d)==true)
        {
            res[qi++]=asf;
            return true;
        }
        visited.add(s);
        boolean rec=false;
        for(String nv:g.get(s).keySet())
        {
            if(visited.contains(nv)==false)
                rec=rec || dfs(nv,d,asf*g.get(s).get(nv));
        }
        return rec;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        res=new double[queries.size()];
        for(int i=0;i<equations.size();i++)
        {
            String u=equations.get(i).get(0);
            String v=equations.get(i).get(1);
            addEdge(u,v,values[i]);
        }
        for(int i=0;i<queries.size();i++)
        {
            String u=queries.get(i).get(0);
            String v=queries.get(i).get(1);
            if(g.containsKey(u)==false || g.containsKey(v)==false)
            {
                res[qi++]=-1.0;
                continue;
            }
            visited=new HashSet<>();   
            boolean rec=dfs(u,v,1.0);
            if(!rec)
                res[qi++]=-1.0;
        }
        return res;
    }
}