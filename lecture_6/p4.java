public class p4 {
    public static int solveABC(String s) {
        int a=0;
        int b=0;
        int c=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='a')
                a=2*a+1;
            else if(ch=='b')
                b=2*b+a;
            else if(ch=='c')
                c=2*c+b;
        }
        return c;
    }
    public static void main(String args[])
    {
        String s="abbc";
        System.out.println(solveABC(s));
    }
}