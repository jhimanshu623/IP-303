public class p7 {
    public static int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int ans=0;
        int msf=prices[0]; //minimum so far
        for(int i=1;i<prices.length;i++)
        {
            ans=Math.max(ans,prices[i]-msf);
            if(prices[i]<msf)
                msf=prices[i];
        }
        return ans;
    }
    public static void main(String args[])
    {
        int prices[]={7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }   
}