public class p1
{
    public static int maxProfit(int k,int[] prices) {
        if(prices.length==0)
            return 0;

        // unlimited number of transactions in O(n)
        if (k >=  prices.length/2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }
        int sell[];
        int buy[]=new int[prices.length];
        
        for(int i=1;i<=k;i++)
        {
            sell=new int[prices.length];
            int maxDiff=-prices[0];
            for(int j=1;j<prices.length;j++)
            {
                sell[j]=Math.max(sell[j-1],prices[j]+maxDiff);
                maxDiff=Math.max(maxDiff,buy[j]-prices[j]);
            }
            buy=sell;
        }
        return buy[prices.length-1];
    }
    public static void main(String args[])
    {
        int[] prices={2,4,1};
        int k=2;
        System.out.println((maxProfit(k,prices)));
    }
}