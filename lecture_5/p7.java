public class p6 {
    public static int solve(int coins[],int i,int j,int strg[][])
    {
        if(i>=j)
            return 0;
        else if(j==i+1)
            return Math.max(coins[i],coins[j]);
        if(strg[i][j]!=0)
            return strg[i][j];
        int one=coins[i]+Math.min(solve(coins,i+2,j,strg),solve(coins,i+1,j-1,strg));
        int two=coins[j]+Math.min(solve(coins,i,j-2,strg),solve(coins,i+1,j-1,strg));
        int res=Math.max(one,two);
        strg[i][j]=res;
        return res;
    }
    // memorization
    public static int twoPlayers(int coins[])
    {
        int strg[][]=new int[coins.length][coins.length];
        return solve(coins,0,coins.length-1,strg);
    }


    // tabulation
    public static int optimalStrategy(int coins[])
    {
        int strg[][]=new int[coins.length][coins.length];
        for(int g=1;g<strg.length;g+=2)
        {
            for(int i=0;i<strg.length-g;i++)
            {
                int j=i+g;
                if(g==1)
                    strg[i][j]=Math.max(coins[i],coins[j]);
                else
                {
                    int left=Math.min(strg[i][j-2],strg[i+1][j-1])+coins[j];
                    int right=Math.min(strg[i+2][j],strg[i+1][j-1])+coins[i];
                    strg[i][j]=Math.max(left,right);
                }
            }
        }
        return strg[0][strg[0].length-1];
    }
    public static void main(String args[])
    {
        int coins[]={20,30,2,2,2,10};
        System.out.println(twoPlayers(coins));

        System.out.println(optimalStrategy(coins));
    }
}