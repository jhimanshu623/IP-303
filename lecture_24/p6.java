import java.util.*;
public class p6 {
    public static int largestRectangleArea(int[] arr) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            while(st.peek()!=-1 && arr[i]<arr[st.peek()])
            {
                int h=arr[st.pop()];
                int w=i-st.peek()-1;
                int a=h*w;
                ans=Math.max(ans,a);
            }
            st.push(i);
        }
        while(st.peek()!=-1)
        {
            int h=arr[st.pop()];
            int w=arr.length-st.peek()-1;
            int a=h*w;
            ans=Math.max(ans,a);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
}