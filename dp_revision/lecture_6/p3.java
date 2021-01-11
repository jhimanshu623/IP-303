class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        ArrayList<Long> arr=new ArrayList<>();
        arr.add((long)1);
        int p2=0,p3=0,p5=0;
        for(int i=1;i<n;i++)
        {
            long min=Math.min(2*arr.get(p2),Math.min(3*arr.get(p3),5*arr.get(p5)));
            arr.add(min);
            if(2*arr.get(p2)==min)
                p2++;
            if(3*arr.get(p3)==min)
                p3++;
            if(5*arr.get(p5)==min)
                p5++;
        }
        return arr.get(n-1);
    }
}