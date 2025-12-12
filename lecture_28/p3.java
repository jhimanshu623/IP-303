import java.util.Stack;
public class p3 {
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
    public static int prefixEvaluation(String s)
    {
        Stack<Integer> st=new Stack<>();
        for(int i=s.length()-1;i>=0;i--)
        {
            char c=s.charAt(i);
            if(c>='0' && c<='9')
                st.push(c-'0');
            else
            {
                int pop1=st.pop();
                int pop2=st.pop();
                st.push(solve(pop1, pop2, c));
            }
        }
        return st.pop();
    }
    public static String prefixToPostfix(String s)
    {
        Stack<String> st=new Stack<>();
        for(int i=s.length()-1;i>=0;i--)
        {
            char c=s.charAt(i);
            if(c>='0' && c<='9')
                st.push(c+"");
            else
            {
                String pop1=st.pop();
                String pop2=st.pop();
                st.push(pop1+pop2+c);
            }
        }
        return st.pop();
    }
    public static String prefixToInfix(String s)
    {
        Stack<String> st=new Stack<>();
        for(int i=s.length()-1;i>=0;i--)
        {
            char c=s.charAt(i);
            if(c>='0' && c<='9')
                st.push(c+"");
            else
            {
                String pop1=st.pop();
                String pop2=st.pop();
                st.push( ('('+"") + pop1+c+pop2 + (')'+"") );
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        String s="-+2*31+3*41";
        System.out.println(prefixEvaluation(s));
        System.out.println(prefixToPostfix(s));
        System.out.println(prefixToInfix(s));
    }
}