import java.util.Stack;
public class p2 {
    public static int solve(int val1,int val2,char c)
    {
        switch(c)
        {
            case '+':
                return val1+val2;
            case '-':
                return val1-val2;
            case '*':
                return val1*val2;
            case '/':
                return val1/val2;
            case '%':
                return val1%val2;
            case '^':
                return (int)Math.pow(val1,val2);
            default:
                break;
        }
        return -1;
    }
    public static int postfixEvaluation(String s)
    {
        Stack<Integer> st=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c>='0' && c<='9')
                st.push(c-'0');
            else
            {
                int pop1=st.pop();
                int pop2=st.pop();
                st.push(solve(pop2, pop1, c));
            }
        }
        return st.pop();
    }
    public static String postfixToPrefix(String s)
    {
        Stack<String> st=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c>='0' && c<='9')
                st.push(c+"");
            else
            {
                String pop1=st.pop();
                String pop2=st.pop();
                st.push(c+pop2+pop1);
            }
        }
        return st.pop();
    }
    public static String postfixToInfix(String s)
    {
        Stack<String> st=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c>='0' && c<='9')
                st.push(c+"");
            else
            {
                String pop1=st.pop();
                String pop2=st.pop();
                st.push( ('('+"") + pop2+c+pop1 + (')'+"") );
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        String s="231*+341*+-";
        System.out.println(postfixEvaluation(s));
        System.out.println(postfixToPrefix(s));
        System.out.println(postfixToInfix(s));
    }
}