public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        int s=0;
        int d=k;
        for(int i=2;i<=n;i++)
        {
            int ns=d;
            int nd=(s+d)*(k-1);
            s=ns;
            d=nd;
        }
        return s+d;
    }
}