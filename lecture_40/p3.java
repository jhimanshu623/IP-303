public class Solution {
    /**
     * @param words1: a list of string
     * @param words2: a list of string
     * @param pairs: a list of string pairs
     * @return: return a boolean, denote whether two sentences are similar or not
     */
    HashMap<String,Integer> map=new HashMap<>();
    ArrayList<Integer> par=new ArrayList<>();
    ArrayList<Integer> rank=new ArrayList<>();
    public int find(int x)
    {
        if(par.get(x)==x)
            return x;
        int px=find(par.get(x));
        par.set(x,px);
        return px;
    }
    public void merge(int x,int y)
    {
        int xl=find(x);
        int yl=find(y);
        if(rank.get(xl)<rank.get(yl))
            par.set(xl,yl);
        else if(rank.get(yl)<rank.get(xl))
            par.set(yl,xl);
        else
        {
            par.set(xl,yl);
            rank.set(yl,rank.get(yl)+1);
        }
    }
    
    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length!=words2.length)
            return false;
        int counter=0;
        for(int i=0;i<pairs.size();i++)
        {
            if(map.containsKey(pairs.get(i).get(0)) == false){
                map.put(pairs.get(i).get(0),counter);
                par.add(counter);
                rank.add(1);
                counter++;
            }
            if(map.containsKey(pairs.get(i).get(1)) == false){
                map.put(pairs.get(i).get(1),counter);
                par.add(counter);
                rank.add(1);
                counter++;
            }
            int x=map.get(pairs.get(i).get(0));
            int y=map.get(pairs.get(i).get(1));
            merge(x,y);
        }
        for(int i=0;i<words1.length;i++)
        {
            if(words1[i].equals(words2[i]) == true)
                continue;
            else
            {
                if(map.get(words1[i])==null || map.get(words2[i])==null)
                    return false;
                int xl=find(map.get(words1[i]));
                int yl=find(map.get(words2[i]));
                if(xl!=yl){
                    return false;
                }
            }
        }
        return true;
    }
}