class Solution {
    int [][] g;
    public void addSlash(int r,int c,char ch)
    {
        if(ch=='/')
        {
            g[r+2][c]=1;
            g[r+1][c+1]=1;
            g[r][c+2]=1;
        }
        else
        {
            g[r][c]=1;
            g[r+1][c+1]=1;
            g[r+2][c+2]=1;
        }
    }
    public void display()
    {
       for(int i=0;i<g.length;i++)
       {
           for(int j=0;j<g[i].length;j++)
                System.out.print(g[i][j]+" ");
       System.out.println();
       }
        System.out.println();
    }
    public void dfs(int r,int c)
    {
        g[r][c]=1;
        if(c+1<g.length && g[r][c+1]==0)
            dfs(r,c+1);
        if(r+1<g.length && g[r+1][c]==0)
            dfs(r+1,c);
        if(c-1>=0 && g[r][c-1]==0)
            dfs(r,c-1);
        if(r-1>=0 && g[r-1][c]==0)
            dfs(r-1,c);
    }
    
    public int regionsBySlashes(String[] grid) {
        g=new int[grid.length*3][grid.length*3];
        for(int i=0;i<grid.length;i++)
        {
            String s=grid[i];
            int j=0;
            while(j<s.length())
            {
                char ch=s.charAt(j);
                if(ch=='/' || ch=='\\')
                    addSlash(i*3,j*3,ch);
                j++;
            }
        }
        int count=0;
        for(int i=0;i<g.length;i++)
        {
            for(int j=0;j<g[i].length;j++)
            {
                if(g[i][j]==0)
                {
                    count++;
                    dfs(i,j);
                }
            }
        }
        return count;
    }
}

// using dsu

class Solution {
    int[] par;
    int[] rank;
    public int find(int x)
    {
        if(par[x]==x)
            return x;
        par[x]=find(par[x]);
        return par[x];
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
    public int regionsBySlashes(String[] grid) {
        int n=grid.length+1;
        par=new int[n*n];
        rank=new int[n*n];
        for(int i=0;i<par.length;i++)
        {
            par[i]=i;
            rank[i]=1;
        }
        for(int j=1;j<n;j++)
        {
            int x=0;
            int y=j;
            merge(x,y);
        }
        for(int i=1;i<n;i++)
        {
            int x=0;
            int y=i*n+0;
            merge(x,y);
        }
        for(int j=1;j<n;j++)
        {
            int x=(n-1)*n+0;
            int y=(n-1)*n+j;
            merge(x,y);
        }
        for(int i=1;i<n;i++)
        {
            int x=n-1;
            int y=i*n+n-1;
            merge(x,y);
        }
                     
        int cycle=1;
        for(int i=0;i<grid.length;i++)
        {
            String s=grid[i];
            for(int j=0;j<s.length();j++)
            {
                char ch=s.charAt(j);
                int x;
                int y;
                if(ch==' ')
                    continue;
                if(ch=='\\')
                {
                    x=i*n+j;
                    y=(i+1)*n+j+1;
                }
                else 
                {
                    x=(i+1)*n+j;
                    y=i*n+j+1;
                }
                if(merge(x,y)==false)
                    cycle++;
            }
        }
        return cycle;
    }
}