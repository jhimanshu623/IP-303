// not worked

public class p6
{
    public static int paintHouse2(int[][] ques)
    {
        if(ques.length==0)
            return 0;
        int min=Integer.MAX_VALUE;
        int smin=Integer.MAX_VALUE;
        int nmin=Integer.MAX_VALUE;
        int nsmin=Integer.MAX_VALUE;
        for(int j=0;j<ques[0].length;j++)
        {
            if(ques[0][j]<min){
                min=ques[0][j];
                if(ques[0][j]>min && ques[0][j]<smin)
                    smin=ques[0][j];
            }
            
        } 
        int strg[][]=new int[ques.length][ques[0].length];
        for(int i=0;i<strg.length;i++)
        {
            for(int j=0;j<strg[0].length;j++)
            {
                if(i==0)
                {
                    strg[i][j]=ques[i][j];
                }
                else
                {
                    strg[i][j]=ques[i][j];
                    if(min!=strg[i-1][j])
                        strg[i][j]+=min;
                    else
                        strg[i][j]+=smin;
                    if(strg[i][j]>nmin && strg[i][j]<nsmin)
                        nsmin=strg[i][j];
                    if(strg[i][j]<nmin)
                        nmin=strg[i][j];
                }
            }
            if(i!=0)
            {
                min=nmin;
                smin=nsmin;
            }
        }
        for(int a[]:strg)
        {
            for(int i:a)
                System.out.print(i+" ");
            System.out.println();
        }
        int ans=Integer.MAX_VALUE;
        for(int k=0;k<strg[0].length;k++)
        {
            ans=Math.min(ans,strg[strg.length-1][k]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int ques[][]={
            {3,2,1,5},
            {2,12,4,3},
            {13,0,9,8},
            {11,6,2,2},
            {0,1,3,4}
        };
        System.out.println(paintHouse2(ques));
    }
}