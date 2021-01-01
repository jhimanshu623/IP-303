class Geeks 
{
    static class Pair implements Comparable<Pair>
    { 
        int l;
        int w;
        int h;
        Pair(int l,int w,int h)
        {
            this.l=l;
            this.w=w;
            this.h=h;   
        }
        public int compareTo(Pair other)
        {
            if(this.l == other.l)
                return other.w - this.w;
            return this.l - other.l;
        }
    }
    
    public static int lis(Pair[] boxes)
    {
        int[] maxHeight=new int[boxes.length];
        int ans=0;
        for(int i=0;i<boxes.length;i++)
        {
            maxHeight[i]=boxes[i].h;
            for(int j=0;j<i;j++)
            {
                if(boxes[i].w > boxes[j].w)
                    maxHeight[i]=Math.max(maxHeight[i] ,boxes[i].h + maxHeight[j]);
            }
            ans=Math.max(ans,maxHeight[i]);
        }
        return ans;
    }

    public static int maxHeight(int height[], int width[], int length[], int n)
    {
       Pair[] boxes=new Pair[3*height.length]; 
    //    for(int i=0;i<height.length;i++)
    //    {
    //        int h=height[i];
    //        int w=width[i];
    //        int l=length[i];
    //        int tl,tw;
    //        if(h>=w)
    //        {
    //            tl=h;
    //            tw=w;
    //        }
    //        else
    //        {
    //            tl=w;
    //            tw=h;
    //        }
    //        boxes[i] = new Pair(tl,tw ,l);
    //        if(h>=l)
    //        {
    //            tl=h;
    //            tw=l;
    //        }
    //        else
    //        {
    //            tl=l;
    //            tw=h;
    //        }
    //        boxes[i+1] = new Pair(tl ,tw ,w);
    //        if(l>=w)
    //        {
    //            tl=l;
    //            tw=w;
    //        }
    //        else
    //        {
    //            tl=w;
    //            tw=l;
    //        }
    //        boxes[i+2] = new Pair(tl ,tw ,h);
    //    }
        for(int i=0;i<height.length;i++)
        {
            int h=height[i];
            int w=width[i];
            int l=length[i];
            int tl,tw;
            boxes[3*i] = new Pair(Math.max(h,w) ,Math.min(h,w), l);
            boxes[3*i+1] = new Pair(Math.max(h,l) ,Math.min(h,l) ,w);
            boxes[3*i+2] = new Pair(Math.max(l,w) ,Math.min(l,w),h);
        }
        Arrays.sort(boxes);
        return lis(boxes);
   }
}