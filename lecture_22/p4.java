public class p4 {
    public static int minDominoRotations(int[] a, int[] b) {
        int a1=0;
        int a2=0;
        int b1=0;
        int b2=0;
        for(int i=0;i<a.length;i++)
        {
            if(a1!=Integer.MAX_VALUE && a[i]!=a[0])
            {
                if(b[i]==a[0])
                    a1+=1;
                else
                    a1=Integer.MAX_VALUE;
            }
            if(a2!=Integer.MAX_VALUE && a[i]!=b[0])
            {
                if(b[i]==b[0])
                    a2+=1;
                else
                    a2=Integer.MAX_VALUE;
            }
            if(b1!=Integer.MAX_VALUE && b[i]!=a[0])
            {
                if(a[i]==a[0])
                    b1+=1;
                else
                    b1=Integer.MAX_VALUE;
            }
            if(b2!=Integer.MAX_VALUE && b[i]!=b[0])
            {
                if(a[i]==b[0])
                    b2+=1;
                else
                    b2=Integer.MAX_VALUE;
            }
        }
        if(a1==Integer.MAX_VALUE && a2==Integer.MAX_VALUE && b1==Integer.MAX_VALUE && b2==Integer.MAX_VALUE)
            return -1;
        return Math.min(a1, Math.min(a2, Math.min(b1,b2)));
    }

    public static int minDominoRotations2(int[] a, int[] b) {
        int countA[]=new int[7];
        int countB[]=new int[7];
        int same[]=new int[7];
        for(int i=0;i<a.length;i++)
        {
            countA[a[i]]++;
            countB[b[i]]++;
            if(a[i]==b[i])
                same[a[i]]++;
        }
        for(int i=1;i<countA.length;i++)
        {
            // countA[i]+countB[i]-same[i]==a.length is sufficient , 
            // countA[i]+countB[i]-same[i]>a.length not required.
            if(countA[i]+countB[i]-same[i]>=a.length)
               return Math.min(countA[i],countB[i])-same[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int a[]={2,1,2,4,2,2};
        int b[]={5,2,2,2,3,2};
        System.out.println(minDominoRotations(a, b));
        System.out.println(minDominoRotations2(a, b));
    }
}