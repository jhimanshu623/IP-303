public class p8
{
    public static int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }
    public static void main(String args[])
    {
        int a[]={0,0,1,1,0,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0};
        int k=3;
        System.out.println(longestOnes(a, k));
    }
}