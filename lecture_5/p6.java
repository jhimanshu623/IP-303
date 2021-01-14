// https://leetcode.com/problems/can-i-win/

public class p6 {
    
    public static boolean canIWin(int mci,int dt,int isTaken,HashMap<Integer,Boolean> strg) {
        if(dt<=0)
        {
            return false; 
        }
        if(strg.containsKey(isTaken))
            return strg.get(isTaken);
        boolean res=false;
        for(int i=1;i<=mci;i++)
        {
            int mask=(1<<i);
            if((isTaken & mask) == 0)
            {
                isTaken^=mask;
                // if(dt-i<=0)
                // {
                //     return true; 
                // }
                if(res || !canIWin(mci, dt-i, isTaken,strg))
                    return true;
                isTaken^=mask;
            }
        }
        strg.put(isTaken,res);
        return res;
    }
    public static boolean canIWin(int mci, int dt) {
        // required if dt==0 and for other cases optimization
        if(dt<=mci)
            return true;
        int isTaken=0;
        int sum = (1+mci)*mci/2;
        // optimization
        if(sum==dt && mci%2==1)
            return true;
        // required
        if(sum < dt)
            return false;
        HashMap<Integer,Boolean> strg=new HashMap<>();
        return canIWin(mci,dt,isTaken,strg);
    }
    public static void main(String args[])
    {
        int mci=10;
        int dt=11;
        System.out.println(canIWin(mci,dt));
    }
}