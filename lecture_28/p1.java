import java.util.Stack;

public class p1 {
    public static int getPriority(char c)
    {
        switch(c)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                break;
        }
        return -1;
    }
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
    public static int infixEvaluation(String s)
    {
        Stack<Integer> vs=new Stack<>();
        Stack<Character> os=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c>='0' && c<='9')
                vs.push(c-'0');
            else if(c=='(')
                os.push(c);
            else if(c==')')
            {
                while(os.peek()!='(')
                {
                    int val1=vs.pop();
                    int val2=vs.pop();
                    char cs=os.pop();
                    vs.push(solve(val2, val1, cs));
                }
                os.pop();
            }
            else
            {
                while(os.size()>0 && os.peek()!='(' && getPriority(c)<=getPriority(os.peek()))
                {
                    int val1=vs.pop();
                    int val2=vs.pop();
                    char cs=os.pop();
                    vs.push(solve(val2, val1, cs));
                }
                os.push(c);
            }
        }
        while(os.size()>0)
        {
            int val1=vs.pop();
            int val2=vs.pop();
            char cs=os.pop();
            vs.push(solve(val2, val1, cs));
        }
        return vs.pop();
    }

    // infix to postfix
    public static String infixToPostfix(String s)
    {
        Stack<String> vs=new Stack<>();
        Stack<Character> os=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c>='0' && c<='9')
                vs.push(c+"");
            else if(c=='(')
                os.push('(');
            else if(c==')')
            {
                while(os.peek()!='(')
                {
                    String val1=vs.pop();
                    String val2=vs.pop();
                    char cs=os.pop();
                    vs.push(val2+val1+cs);
                }
                os.pop();
            }
            else
            {
                while(os.size()>0 && os.peek()!='(' && getPriority(c)<=getPriority(os.peek()))
                {
                    String val1=vs.pop();
                    String val2=vs.pop();
                    char cs=os.pop();
                    vs.push(val2+val1+cs);
                }
                os.push(c);
            }
        }
        while(os.size()>0)
        {
            String val1=vs.pop();
            String val2=vs.pop();
            char cs=os.pop();
            vs.push(val2+val1+cs);
        }
        return vs.pop();
    }

    // infix to prefix
    public static String infixToPrefix(String s)
    {
        Stack<String> vs=new Stack<>();
        Stack<Character> os=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c>='0' && c<='9')
                vs.push(c+"");
            else if(c=='(')
                os.push('(');
            else if(c==')')
            {
                while(os.peek()!='(')
                {
                    String val1=vs.pop();
                    String val2=vs.pop();
                    char cs=os.pop();
                    vs.push(cs+val2+val1);
                }
                os.pop();
            }
            else
            {
                while(os.size()>0 && os.peek()!='(' && getPriority(c)<=getPriority(os.peek()))
                {
                    String val1=vs.pop();
                    String val2=vs.pop();
                    char cs=os.pop();
                    vs.push(cs+val2+val1);
                }
                os.push(c);
            }
        }
        while(os.size()>0)
        {
            String val1=vs.pop();
            String val2=vs.pop();
            char cs=os.pop();
            vs.push(cs+val2+val1);
        }
        return vs.pop();
    }
    public static void main(String[] args) {
        String s="2+3*1-(3+4*1)";
        // String s="3-2*4/1+3^2";
        // infix evaluation
        System.out.println(infixEvaluation(s));
        System.out.println(infixToPostfix(s));
        System.out.println(infixToPrefix(s));
    }    
}