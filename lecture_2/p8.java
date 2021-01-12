public class p8 {
    public static int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int ans=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1])
                ans+=prices[i]-prices[i-1];
        }
        return ans;
    }

    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length==0)
                return 0;
            int bsp=-prices[0];
            int ssp=0;
            for(int i=1;i<prices.length;i++)
            {
                int nbsp=Math.max(bsp,ssp-prices[i]);
                int nssp=Math.max(ssp,bsp+prices[i]);
                bsp=nbsp;
                ssp=nssp;
            }
            return ssp;
        }
    }
    public static void main(String args[])
    {
        int prices[]={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }   
}