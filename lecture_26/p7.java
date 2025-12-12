import java.util.Stack;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p7 {

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<k;i++)
        {
            st.push(q.poll());
        }
        while(st.size()>0)
        {
            q.add(st.pop());
        }
        int c=q.size()-k;
        while(c-->0)
        {
            int x=q.poll();
            q.add(x);
        }
        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> que=new LinkedList<Integer>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
        int k=5;
        que=modifyQueue(que,k);
        for(int i:que)
            System.out.print(i+" ");
        System.out.println();
    }
}