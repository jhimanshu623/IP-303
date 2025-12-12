public class p1
{
    public static void transpose(int mat[][])
    {
        for(int i=0;i<mat.length;i++)
        {
            for(int j=i;j<mat.length;j++)
            {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }
    public static void rotate(int[][] mat) {
        transpose(mat);
        int i=0;
        int j=mat.length-1;
        while(i<j)
        {
            for(int r=0;r<mat.length;r++)
            {
                int t=mat[r][i];
                mat[r][i]=mat[r][j];
                mat[r][j]=t;
            }
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int mat[][]={
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        rotate(mat);
        for(int arr[]:mat)
        {
            for(int i:arr)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}