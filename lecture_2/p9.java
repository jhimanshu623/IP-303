import java.util.Arrays;

public class p9 {
    public static int solve(int prices[],int idx,int k,int strg[])
    {
        if(k==2)
        return 0;
        if (idx >= prices.length)
            return 0;
        if(strg[idx]!=-1)
            return strg[idx];
        int oprofit=0;
        for(int i=idx;i<prices.length;i++)
        {
            int profit=0;
            for(int j=i+1;j<prices.length;j++)
            {
                if(prices[j]>prices[i])
                    profit=Math.max(profit,(prices[j]-prices[i])+solve(prices,j+1,k+1,strg));
            }
            oprofit=Math.max(oprofit,profit);
        }
        strg[idx]=oprofit;
        return oprofit;
    }
    // memorization 1803 ms
    public static int maxProfit_01(int[] prices) {
        int[] strg=new int[prices.length];
        Arrays.fill(strg,-1);
        return solve(prices,0,0,strg);
    }

    // tabulation 2ms
    public static int maxProfit_02(int prices[])
    {
        if(prices.length==0)
            return 0;
        int left[]=new int[prices.length];
        int minsf=prices[0];
        left[0]=0;
        for(int i=1;i<left.length;i++)
        {
            left[i]=Math.max(left[i-1],(prices[i]-minsf));
            if(minsf>prices[i])
                minsf=prices[i];
        }
        int right[]=new int[prices.length];
        int maxsf=prices[prices.length-1];
        right[prices.length-1]=0;
        for(int i=prices.length-2;i>=0;i--)
        {
            right[i]=Math.max(right[i+1],maxsf-prices[i]);
            if(maxsf<prices[i])
                maxsf=prices[i];
        }
        int ans=0;
        for(int i=0;i<left.length;i++)
        {
            ans=Math.max(ans,left[i]+right[i]);
        }
        return ans;
    }

    // tabulation using one array 2ms
    public static int maxProfit_03(int prices[])
    {
        if(prices.length==0)
            return 0;
        int left[]=new int[prices.length];
        int minsf=prices[0];
        left[0]=0;
        for(int i=1;i<left.length;i++)
        {
            left[i]=Math.max(left[i-1],(prices[i]-minsf));
            if(minsf>prices[i])
                minsf=prices[i];
        }
        int maxsf=prices[prices.length-1];
        int rp=0;
        int ans=0;
        for(int i=prices.length-2;i>=0;i--)
        {
            rp=Math.max(rp,maxsf-prices[i]);
            if(maxsf<prices[i])
                maxsf=prices[i];
            ans=Math.max(ans,left[i]+rp);
        }
        return ans;
    }
    // tabulation constant space
    public static int maxProfit_04(int prices[])
    {
        int b=Integer.MIN_VALUE;
        int bs=0;
        int bsb=Integer.MIN_VALUE;
        int bsbs=0;
        for(int i=0;i<prices.length;i++)
        {
            bsbs=Math.max(bsbs,bsb+prices[i]);
            bsb=Math.max(bsb,bs-prices[i]);
            bs=Math.max(bs,b+prices[i]);
            b=Math.max(b,-prices[i]);
        }
        return Math.max(bs,bsbs);
    }
    public static void main(String args[])
    {
        int prices[]={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit_01(prices));  
        System.out.println(maxProfit_02(prices));  
        System.out.println(maxProfit_03(prices));  
        System.out.println(maxProfit_04(prices));  

    }   
}