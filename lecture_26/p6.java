import java.util.Stack;
public class p6 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<Integer>();
        int i=0;
        int j=0;
        while(i<pushed.length)
        {
            if(st.size()>0 && st.peek()==popped[j]){
                st.pop();
                j++;
            }
            else
            {
                st.push(pushed[i]);
                i++;
            }
        }
        while(st.size()>0)
        {
            if(st.peek()!=popped[j])
                return false;
            st.pop();
            j++;
        }
        return true;
    }

    // O(1) space but complicated
    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        int i=-1;
        int j=0;
        for(int val:pushed)
        {
            i++;
            pushed[i]=val;
            if(i!=-1 && pushed[i]==popped[j]){
                i--;    
                j++;
            }
        }
        while(i>=0)
        {
            if(pushed[i]!=popped[j])
                return false;
            i--;
            j++;
        }
        return true;
    }

    // copied
    public boolean validateStackSequences3(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for (int x : pushed) {
            pushed[i++] = x;
            while (i > 0 && pushed[i - 1] == popped[j]) {
                --i; ++j;
            }
        }
        return i == 0;
    }
    public static void main(String[] args) {
        int pushed[]={1,2,3,4,5};
        int popped[]={4,3,5,1,2};
        System.out.println(validateStackSequences(pushed,popped));
        System.out.println(validateStackSequences2(pushed,popped));
    }    
}