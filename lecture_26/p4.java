import java.util.Queue;
import java.util.LinkedList;

public class p4 {
    public static void printAllBinary(int n)
    {
        String s="1";
        Queue<String> que=new LinkedList<>();
        int c=0;
        que.add(s);
        while(c<n)
        {
            String rs=que.poll();
            System.out.print(rs+" ");
            c++;
            que.add(rs+"0");
            que.add(rs+"1");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n=5;
        printAllBinary(n);
    }    
}