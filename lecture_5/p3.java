import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class p3 {
    // tabulation 
    public boolean canCross_01(int[] stones) {
        int n = stones.length;
        int last=stones[n-1];
        HashMap<Integer, HashSet> map = new HashMap<>();
        for(int i =0; i< stones.length; i++){
            map.put(stones[i], new HashSet());
        }
        map.get(stones[0]).add(0);
        for(int i=0;i<n;i++){
            Set<Integer> arr=map.get(stones[i]);
            for(int stone :arr){
                for(int jump = stone-1;jump<=stone+1;jump++){
                    if(stones[i]+jump==last) return true;
                    
                    if(map.containsKey(stones[i]+jump)&&jump>0){
                        map.get(stones[i] + jump).add(jump);
                    }
                }
            }
        }
        return false;
    }

    // tabulation 59ms
    public static boolean canCross_02(int stones[])
    {
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

    // memorization works 18ms
    // static HashMap<Integer,Boolean> isValid=new HashMap<>();
    // public static int frogJump(int cs,int ds,int pj,HashMap<String,Integer> strg)
    // {
    //     if(cs>ds)
    //        return -1;
    //     if(cs==ds)
    //         return 1;
    //     String dpKey = cs+"_"+pj;
    //     if(strg.containsKey(dpKey))
    //         return strg.get(dpKey);
    //     int res=-1;
    //     if(pj-1>=0 && isValid.containsKey(cs+pj-1))
    //         res=frogJump(cs+(pj-1),ds,pj-1,strg);
    //     if(pj>0 && res!=1 && isValid.containsKey(cs+pj))
    //         res=frogJump(cs+pj,ds,pj,strg); 
    //     if(pj+1>=0 && res!=1 && isValid.containsKey(cs+pj+1))
    //         res=frogJump(cs+pj+1,ds,pj+1,strg);
    //     strg.put(dpKey,res);
    //     return res;
    // }
    // public static boolean canCross_03(int stones[])
    // {
    //     // this loop optimizing the code
    //     for(int i=0;i<stones.length-1;i++)
    //     {
    //         if(stones[i+1]>stones[i]+i+1)
    //             return false; 
    //     }
    //     for(int val:stones)
    //         isValid.put(val,true);
        
    //     HashMap<String,Integer> strg=new HashMap<>();     
    //     return (frogJump(stones[0], stones[stones.length-1], 0,strg)==1)?true:false;
    // }

    // memorization 8ms
    static HashMap<Integer,Boolean> isValid=new HashMap<>();
    static HashMap<Integer,HashMap<Integer,Integer>> strg=new HashMap<>();        
    public static int frogJump(int cs,int ds,int pj)
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
        HashMap<Integer,Integer> im=strg.getOrDefault(cs,new HashMap<Integer,Integer>());
        im.put(pj,res);
        strg.put(cs,im);
        return res;
    }
    public static boolean canCross_04(int stones[])
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
    public static void main(String[] args) {
        int stones[]={0,1,3,5,6,8,12,17};
        // System.out.println(canCross_02(stones));
        System.out.println(canCross_04(stones));
    }
}