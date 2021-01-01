public class Solution {
    /**
     * @param symb: the array of symbols
     * @param oper: the array of operators
     * @return: the number of ways
     */
    public int countParenth(char[] symb, char[] oper) {
        int n=symb.length;
        int[][] True=new int[n][n];
        int[][] False=new int[n][n];
        for(int g=0;g<n;g++)
        {
            for(int i=0;i<n-g;i++)
            {
                int j=i+g;
                if(g==0)
                {
                    True[i][j]=(symb[i]=='T')?1:0;
                    False[i][j]=(symb[i]=='F')?1:0;
                    continue;
                }
                for(int k=0;k<g;k++)
                {
                    int lt=True[i][i+k];
                    int rt=True[i+1+k][j];
                    int lf=False[i][i+k];
                    int rf=False[i+1+k][j];
                    if(oper[i+k]=='|')
                    {
                        True[i][j]+=lt*rt + lt*rf + lf*rt;
                        False[i][j]+=lf*rf;
                    }
                    else if(oper[i+k]=='&')
                    {
                        True[i][j]+=lt*rt;
                        False[i][j]+=lt*rf + lf*rt + lf*rf;
                    }
                    else
                    {
                        True[i][j]+=lt*rf + lf*rt;
                        False[i][j]+=lt*rt + lf*rf;
                    }
                }
            }
        }
        return True[0][n-1];
    }
}