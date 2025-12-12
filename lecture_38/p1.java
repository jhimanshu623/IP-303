/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    int[] par;
    int[] rank;
    int[][] visited;
    public int find(int x)
    {
        if(par[x]==x)
            return x;
        int px=find(par[x]);
        par[px]=px;
        return px;
    }
    public boolean merge(int x,int y)
    {
        int xl=find(x);
        int yl=find(y);
        if(xl!=yl)
        {
            if(rank[xl]<rank[yl])
                par[xl]=yl;
            else if(rank[yl]<rank[xl])
                par[yl]=xl;
            else
            {
                par[xl]=yl;
                rank[yl]++;
             }
            return true;
        }
        return false;
    }
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        int count=0;
        par=new int[n*m];
        rank=new int[n*m];
        visited=new int[n][m];
        List<Integer> res=new ArrayList<>();
        
        if(operators==null)
            return res;
        
        for(int i=0;i<par.length;i++)
        {
            par[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<operators.length;i++)
        {
            int r=operators[i].x;
            int c=operators[i].y;
            int pos=r*m+c;
            if(visited[r][c]!=1)
                count++;
            visited[r][c]=1;
            if(c+1<m && visited[r][c+1]==1)
            {
                int npos=r*m+c+1;
                boolean isMerge=merge(pos,npos);
                if(isMerge==true)
                    count--;
            }
            if(r+1<n && visited[r+1][c]==1)
            {
                int npos=(r+1)*m+c;
                boolean isMerge=merge(pos,npos);
                if(isMerge==true)
                    count--;
            }
            if(c-1>=0 && visited[r][c-1]==1)
            {
                int npos=r*m+c-1;
                boolean isMerge=merge(pos,npos);
                if(isMerge==true)
                    count--;
            }
            if(r-1>=0 && visited[r-1][c]==1)
            {
                int npos=(r-1)*m+c;
                boolean isMerge=merge(pos,npos);
                if(isMerge==true)
                    count--;
            }
            res.add(count);
        }
        return res;
    }
}