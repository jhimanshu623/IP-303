class FreqStack {
    HashMap<Integer,Integer> map;
    HashMap<Integer,Stack<Integer>> fmap;
    int mf;
    public FreqStack() {
        map=new HashMap<>();
        fmap=new HashMap<>();
        mf=Integer.MIN_VALUE;
    }
    
    public void push(int x) {
        int f=map.getOrDefault(x,0)+1;
        map.put(x,f);
        mf=Math.max(mf,f);
        if(fmap.containsKey(f)==false)
            fmap.put(f,new Stack<Integer>());
        fmap.get(f).push(x);
    }
    
    public int pop() {
        int ans=fmap.get(mf).pop();
        if(fmap.get(mf).size()==0)
        {
            fmap.remove(mf);
            mf--;
        }
        map.put(ans,map.get(ans)-1);
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */