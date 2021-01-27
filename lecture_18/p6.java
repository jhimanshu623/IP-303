package lecture_18;

public class p6 {

    public static int reachNumber2(int t) {
        int n=0;
        int pos=0;
        t=Math.abs(t);
        while(pos<t)
        {
            n++;
            pos=pos+n;
        }
        if(pos==t || (pos-t)%2==0)
            return n;    
        return ((pos+n+1-t)%2==0)?n+1:n+2;
    }

    // same
    public static int reachNumber(int t) {
        int n=1;
        int pos=0;
        t=Math.abs(t);
        while(pos<t)
        {
            pos=pos+n;
            n++;
        }   
        n--;
        if(pos==t)
            return n;
        else 
        {
            if((pos-t)%2==0)
                return n;
            else
            {
                n++;
                pos=pos+n;
                if((pos-t)%2==0)
                    return n;
                else
                {
                    return n+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int t=12;
        System.out.println(reachNumber(t));
    }
}