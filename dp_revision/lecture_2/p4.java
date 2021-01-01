class Solution {
    class Pair implements Comparable<Pair>
    {
        int h;
        int w;
        Pair(int h,int w)
        {
            this.h=h;
            this.w=w;
        }
        public int compareTo(Pair other)
        {
            if(this.h == other.h)
                return other.w - this.w;
            return this.h - other.h;
        }
    }
    public int lis(Pair[] env)
    {
        int[] minVal=new int[env.length];
        int ans=0;
        for(int i=0;i<env.length;i++)
        {
            int val=env[i].w;
            int l=0;
            int h=ans;
            while(l<h)
            {
                int mid=(l+h)/2;
                if(minVal[mid] < val)
                    l=mid+1;
                else
                    h=mid;
            }
            minVal[l]=val;
            if(l==ans)
                ans++;
        }
        return ans;
    }
    public int maxEnvelopes(int[][] envelopes) {
        Pair[] env=new Pair[envelopes.length];
        for(int i=0;i<envelopes.length;i++)
        {
            int h=envelopes[i][0];
            int w=envelopes[i][1];
            env[i]=new Pair(h,w);
        }
        Arrays.sort(env);
        return lis(env);
    }
}