class Solution {
    class Pair
    {
        String s;
        int c;
        Pair(String s,int c)
        {
            this.s=s;
            this.c=c;
        }
    }
    public int kSimilarity(String a, String b) {
        LinkedList<Pair> que=new LinkedList<>();
        HashSet<String> vis=new HashSet<>();
        que.addLast(new Pair(a,0));
        while(que.size()>0)
        {
            Pair rp=que.removeFirst();
            String rs=rp.s;
            vis.add(rs);
            if(rs.equals(b))
                return rp.c;
            int i=rp.c;
            // int i=0;
            while(rs.charAt(i)==b.charAt(i))
                i++;
            int j=i+1;
            while(j<rs.length())
            {
                if(rs.charAt(j)==b.charAt(i))
                {
                    String ns=rs.substring(0,i)+rs.charAt(j)+rs.substring(i+1,j)+rs.charAt(i)+rs.substring(j+1);
                    if(vis.contains(ns)==false){
                        que.addLast(new Pair(ns,rp.c+1));
                        if(ns.charAt(j)==b.charAt(j))
                            break;
                    }
                }
                j++;
            }
        }
        return 0;
    }
}