
public class p6 {
    public static int maxSumK(int arr[],int s,int e,int k)
    {
        int inc[][]=new int[k+1][e-s+1];
        int exc[][]=new int[k+1][e-s+1];
        for(int i=0;i<inc.length;i++)
        {
            for(int j=0;j<inc[0].length;j++)
            {
                if(i==0)
                {
                    inc[i][j]=0;
                    exc[i][j]=0;
                }
                else if(j==0)
                {
                    inc[i][j]=arr[j+s];
                    exc[i][j]=0;
                }
                else
                {
                    inc[i][j]=arr[j+s]+exc[i-1][j-1];
                    exc[i][j]=Math.max(inc[i][j-1],exc[i][j-1]);
                }
            }
        }
        return Math.max(inc[k][inc[0].length-1],exc[k][exc[0].length-1]);
    }
    public static int maxSizeSlices(int[] slices) {
        if(slices.length==0)
            return 0;
        if(slices.length==3)
            return Math.max(slices[0],Math.max(slices[1],slices[2]));
        int s=0;
        int e=slices.length-1;
        int n=(e-s+1)/3;
        int f1=slices[s]+maxSumK(slices, s+2, e-1, n-1);
        int f2=maxSumK(slices, s+1, e, n);
        return Math.max(f1,f2);
    }
    public static void main(String[] args) {
        int slices[]={1,2,3};
        // System.out.println(maxSumK(slices, 0, slices.length-1, 3));
        System.out.println(maxSizeSlices(slices));
    }
}