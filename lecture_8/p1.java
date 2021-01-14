public class p1 {
    public static int solve(int arr[],int i,int j,int strg[][])
    {
        if(i+1==j)
            return 0;
        if(strg[i][j]!=0)
            return strg[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++)
        {
            ans=Math.min(ans,solve(arr,i,k,strg)+solve(arr,k,j,strg)+arr[i]*arr[j]*arr[k]);
        }
        strg[i][j]=ans;
        return ans;
    }
    public static int minScoreTriangulation(int[] arr) {
        if(arr.length==0)
            return 0;
        int strg[][]=new int[arr.length][arr.length];
        return solve(arr,0,arr.length-1,strg);
    }

    // tabulation
    public static int minScoreTriangulation_02(int[] arr) {
        if(arr.length==0)
            return 0;
        int strg[][]=new int[arr.length][arr.length];
        for(int g=2;g<strg.length;g++)
        {
            for(int i=0;i<strg.length-g;i++)
            {
                int j=i+g;
                if(g==2)
                {
                    strg[i][j]=arr[i]*arr[i+1]*arr[i+2];
                }
                else
                {
                    int ans=Integer.MAX_VALUE;
                    for(int k=i+1;k<j;k++)
                    {
                        int left=strg[i][k];
                        int right=strg[k][j];
                        int tcost=left+right+arr[i]*arr[j]*arr[k];
                        if(tcost<ans)
                            ans=tcost;
                    }
                    strg[i][j]=ans; 
                }
                
            }
        }
        return strg[0][arr.length-1];
    } 
    public static void main(String args[])
    {
        int arr[]={1,2,3};
        System.out.println(minScoreTriangulation(arr));
        System.out.println(minScoreTriangulation_02(arr));
    }
}