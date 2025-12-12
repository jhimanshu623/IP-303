import java.util.Stack;
public class p5 {
    // don't solve for elements whose either left greater not found or right greater.
    public static int trap(int[] height)
    {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int ans=0;
        for(int i=0;i<height.length;i++)
        {
            while(st.peek()!=-1 && height[i]>height[st.peek()])
            {
                int h=height[st.pop()];
                if(st.peek()!=-1)
                    ans+=(i-st.peek()-1)*(Math.min(height[st.peek()],height[i])-h);
            }
            st.push(i);
        }
        return ans;
    }

    // O(1) space 
    public static int trap2(int[] height) {
        int leftmax=0;
        int rightmax=0;
        int ans=0;
        int i=0;
        int j=height.length-1;
        while(i<j)
        {
            if(height[i]<=height[j])
            {
                if(height[i]>leftmax)
                    leftmax=height[i];
                else
                    ans+=leftmax-height[i];
                i++;
            }
            else
            {
                if(height[j]>rightmax)
                    rightmax=height[j];
                else
                    ans+=rightmax-height[j];
                j--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }
}