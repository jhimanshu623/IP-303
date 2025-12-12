import java.util.Stack;

public class p7 {
    public static int largestRectangleArea(int[] arr) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            while(st.peek()!=-1 && arr[i]<arr[st.peek()])
            {
                int a=arr[st.pop()] * (i-st.peek()-1);
                ans=Math.max(ans,a);
            }
            st.push(i);
        }
        while(st.peek()!=-1)
        {
            int a=arr[st.pop()] * (arr.length-st.peek()-1);
            ans=Math.max(ans,a);
        }
        return ans;
    }
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int ans=0;
        int arr[]=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0')
                    arr[j]=0;
                else
                    arr[j]+=1;
            }
            ans=Math.max(ans, largestRectangleArea(arr));
        }
        return ans;
    }
    public static void main(String[] args) {
        char matrix[][]={
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}