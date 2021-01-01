class Solution {
public:
    bool canCross(vector<int>& stones) {
        
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int n=stones.size();
        if(stones[stones.size()-1] > n*(n-1)/2)
            return false;
        
        for(int i=0;i<n-1;i++)
        {
            if(stones[i+1] > stones[i]+i+1)
                return false;
        }
        
        unordered_map<int,unordered_set<int>> map1;
        for(int i:stones)
            map1[i]=unordered_set<int>();
        map1[0].insert(1);
        for(int i=0;i<stones.size();i++)
        {
            int cs=stones[i];
            for(int jump:map1[cs])
            {
                if(map1.count(cs+jump)!=0)
                {
                    if(jump-1>0)
                        map1[cs+jump].insert(jump-1);
                    map1[cs+jump].insert(jump);
                    map1[cs+jump].insert(jump+1);
                }
            }
        }
        int ds=stones[stones.size()-1];
        return (map1[ds].size()!=0);
    }
};

// tabulation 59 ms
class Solution {
    public static boolean canCross(int[] stones)
    {
        for(int i=0;i<stones.length-1;i++)
        {
            if(stones[i+1]>stones[i]+i+1)
                return false; 
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<stones.length;i++)
            map.put(stones[i],i);
        boolean strg[][]=new boolean[stones.length][stones.length];
        strg[1][0]=true;
        for(int j=0;j<strg[0].length;j++)
        {
            for(int i=0;i<strg.length;i++)
            {
                if(strg[i][j]==true)
                {
                    int ns=stones[j]+i;
                    if(map.containsKey(ns))
                    {
                        if(i-1>=0)
                            strg[i-1][map.get(ns)]=true;
                        strg[i][map.get(ns)]=true;
                        if(i+1<strg.length)
                            strg[i+1][map.get(ns)]=true;
                    }
                }
            }
        }

        for(int i=0;i<strg.length;i++)
        {
            if(strg[i][strg[0].length-1]==true)
                return true;
        }
        return false;
    }
}

// memorization
// 8 ms
class Solution {
    HashMap<Integer,Boolean> isValid=new HashMap<>();
    HashMap<Integer,HashMap<Integer,Integer>> strg=new HashMap<>();        
    public int frogJump(int cs,int ds,int pj)
    {
        if(cs>ds)
           return -1;
        if(cs==ds)
            return 1;
        if(strg.containsKey(cs))
        {
            if(strg.get(cs).containsKey(pj))
                return strg.get(cs).get(pj);
        }
        int res=-1;
        if(pj-1>=0 && isValid.containsKey(cs+pj-1))
            res=frogJump(cs+(pj-1),ds,pj-1);
        if(pj>0 && res!=1 && isValid.containsKey(cs+pj))
            res=frogJump(cs+pj,ds,pj); 
        if(pj+1>=0 && res!=1 && isValid.containsKey(cs+pj+1))
            res=frogJump(cs+pj+1,ds,pj+1);
        // HashMap<Integer,Integer> im=new HashMap<>();
        // im.put(pj,res);
        HashMap<Integer,Integer> im=strg.getOrDefault(cs,new HashMap<Integer,Integer>());
        im.put(pj,res);
        strg.put(cs,im);
        return res;
    }
    public boolean canCross(int stones[])
    {
        for(int i=0;i<stones.length-1;i++)
        {
            if(stones[i+1]>stones[i]+i+1)
                return false; 
        }
        for(int val:stones)
            isValid.put(val,true);
        return (frogJump(stones[0], stones[stones.length-1], 0)==1)?true:false;
    }
}