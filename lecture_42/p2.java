public class Solution {
    class Pair
    {
        String s;
        int zp;
        int c;
        Pair(String s,int zp,int c)
        {
            this.s=s;
            this.zp=zp;
            this.c=c;
        }
    }
    public int slidingPuzzle(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        ArrayList<Integer>[] positions=new ArrayList[n*m];
        LinkedList<Pair> que=new LinkedList<>();
        HashSet<String> vis=new HashSet<>();
        String a="";
        String b="123450";
        int zp=-1;
        for(int i=0;i<positions.length;i++)
            positions[i]=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                a+=board[i][j];
                if(board[i][j]==0)
                    zp=i*m+j;
                int p=i*m+j;
                if(j+1<m)
                    positions[p].add(i*m+j+1);
                if(i+1<n)
                    positions[p].add((i+1)*m+j);
                if(j-1>=0)
                    positions[p].add(i*m+j-1);
                if(i-1>=0)
                    positions[p].add((i-1)*m+j);
            }
        }
        
        que.addLast(new Pair(a,zp,0));
        while(que.size()>0)
        {
            Pair rp=que.removeFirst();
            vis.add(rp.s);
            if(rp.s.equals(b))
                return rp.c;
            for(int p=0;p<positions[rp.zp].size();p++)
            {
                int nszp=positions[rp.zp].get(p);
                int j=positions[rp.zp].get(p);
                int i=rp.zp;
                if(i>j)
                {
                    int t=i;
                    i=j;
                    j=t;
                }
                String ns=rp.s.substring(0,i)+rp.s.charAt(j)+rp.s.substring(i+1,j)+rp.s.charAt(i)+rp.s.substring(j+1);
                    if(vis.contains(ns)==false){
                        que.addLast(new Pair(ns,nszp,rp.c+1));
                    }
            }
        }
        return -1;
    }
}class p2 {
    
}