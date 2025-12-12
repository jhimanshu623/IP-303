public class p1 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int d=0;
        int ps=0;
        int start=0;
        for(int i=0;i<gas.length;i++)
        {
            d+=gas[i]-cost[i];
        }
        if(d<0)
            return -1;
        d=0;
        for(int i=0;i<gas.length;i++)
        {
            d=gas[i]-cost[i];
            ps+=d;
            if(ps<0){
                start=(i+1)%gas.length;
                ps=0;
            }
        }
        return start;
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        if(gas.length==0)
            return -1;
        int d=0;
        int mps=Integer.MAX_VALUE;
        int ps=0;
        int start=0;
        for(int i=0;i<gas.length;i++)
        {
            d=gas[i]-cost[i];
            ps+=d;
            if(ps<mps)
            {
                start=(i+1)%gas.length;
                mps=ps;                
            }
        }
        if(ps<0)
            return -1;
        return start;
    }
    public static void main(String args[])
    {
        int gas[]={10,2,3,1,12,2,2,7,3};
        int cost[]={5,4,7,4,3,4,6,2,6};
        System.out.println(canCompleteCircuit(gas,cost));
        System.out.println(canCompleteCircuit2(gas,cost));
    }    
}