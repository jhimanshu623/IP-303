import java.util.Scanner;

public class p3 {
    public static int gcd(int a,int b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public static String dioPhantine(int a,int b,int c)
    {
        int g=gcd(a,b);
        if(c%g==0)
            return "Yes";
        else
            return "No";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            System.out.println("Case "+i+": "+dioPhantine(a,b,c));
        }
    }
}