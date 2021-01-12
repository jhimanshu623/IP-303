public class p5
{
    public static int paintHouse(int ques[][])
    {
        if(ques.length==0)
            return  0;
        int strg[][]=new int[ques.length][ques[0].length];
        for(int i=0;i<strg.length;i++)
        {
            for(int j=0;j<strg[0].length;j++)
            {
                if(i==0)
                    strg[i][j]=ques[i][j];
                else
                {
                    int min=Integer.MAX_VALUE;
                    for(int k=0;k<strg[0].length;k++)
                    {
                        if(k!=j)
                            min=Math.min(min,strg[i-1][k]);
                    }
                    strg[i][j]=ques[i][j]+min;
                }
            }
        }

        int min=Integer.MAX_VALUE;
        for(int k=0;k<strg[0].length;k++)
        {
            min=Math.min(min,strg[strg.length-1][k]);
        }
        return min;
    }
    public static void main(String args[])
    {
        int ques[][]={
            {1,5,7},
            {5,8,4},
            {3,2,9},
            {1,2,4}
        };
        System.out.println(paintHouse(ques));
    }
}