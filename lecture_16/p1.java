package lecture_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
public class p1
{
    class RandomizedCollection {

        /** Initialize your data structure here. */
        HashMap<Integer,HashSet<Integer>> map;
        ArrayList<Integer> arr;
        public RandomizedCollection() {
            map=new HashMap<Integer,HashSet<Integer>>();
            arr=new ArrayList<Integer>();
        }
        
        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            if(!map.containsKey(val))
                map.put(val,new HashSet<>());
            map.get(val).add(arr.size());
            arr.add(val);
            return map.get(val).size()==1;
        }
        
        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val))
                return false;
            int ridx=map.get(val).iterator().next();
            map.get(val).remove(ridx);
            int last=arr.get(arr.size()-1);
            arr.set(ridx,last);
            map.get(last).add(ridx);
            map.get(last).remove(arr.size()-1);
            arr.remove(arr.size()-1);
            if(map.get(val).size()==0)
                map.remove(val);
            return true;
        }
        
        /** Get a random element from the collection. */
        public int getRandom() {
            int idx=(int)(Math.random()*arr.size());
            return arr.get(idx);
        }
    }    
}