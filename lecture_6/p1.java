// https://practice.geeksforgeeks.org/problems/probability-of-knight/0
// https://leetcode.com/problems/knight-probability-in-chessboard/

// passed on leetcode
// fail on geeks
import java.util.LinkedList;
import java.util.*;
import java.text.DecimalFormat;

class GFG {
    public static double knightProbability(int n, int k, int r, int c) {
        if(r>=n || c>=n || r<0 || c<0)
            return 0.0;
        double dp1[][]=new double[n][n];
        double dp2[][]=new double[n][n];
        int dir[][]={
            {-2,-1},
            {-2,1},
            {2,-1},
            {2,1},
            {-1,-2},
            {1,-2},
            {-1,2},
            {1,2}
        };
        dp1[r][c]=1.0;
        while(k-->0)
        {   
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dp1[i][j]!=0)
                    {
                        for(int d=0;d<dir.length;d++)
                        {
                            if(i+dir[d][0]>=0 && i+dir[d][0]<n && j+dir[d][1]>=0 && j+dir[d][1]<n)
                            {
                                dp2[i+dir[d][0]][j+dir[d][1]]+=(dp1[i][j]*(0.125));
                            }
                        }     
                    }
                }
            }
            
            dp1=dp2;
            dp2=new double[n][n]; 
        }
        double ans=0.0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans+=dp1[i][j];
            }
        }
        return ans;
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int x=sc.nextInt();
		    int y=sc.nextInt();
		    int k=sc.nextInt();
		    DecimalFormat df = new DecimalFormat("#.######");
		    double d=knightProbability(n,k,x,y);
		    
		  //  DecimalFormat df=new DecimalFormat("#.######");
		  //  df.setRoundingMode(RoundingMode.FLOOR);
		    System.out.println(df.format(d));
		    
		  //  long ld=(long)(d*10000000) % 10;
		  //  d=((long)(d*1000000)) / 1000000.0;
		    
		  //  System.out.println(d+" ,  "+ ld);
		  //  if(ld > 5) {
		  //      d = d + 0.000001;
		  //      System.out.println(d);
		  //      System.out.printf("%.6f\n",d);
		  //  } 
		  //  else {
		  //      System.out.println(d);
		  //  }
		}
	}
}

    // bfs gives tle
    static class Pair
    {
        int x;
        int y;
        double p;
        Pair(int x,int y,double p)
        {
            this.x=x;
            this.y=y;
            this.p=p;
        }
    }
    public static double knightProbability_02(int n, int k, int r, int c) {
        int dir[][]={
            {-2,-1},
            {-2,1},
            {2,-1},
            {2,1},
            {-1,-2},
            {1,-2},
            {-1,2},
            {1,2}
        };
        LinkedList<Pair> que=new LinkedList<>();
        que.addLast(new Pair(r,c,1));
        while(k-->0)
        {   
            int size=que.size();
            while(size-->0)
            {
                Pair rem=que.removeFirst();
                int i=rem.x;
                int j=rem.y;
                double p=rem.p;
                for(int d=0;d<dir.length;d++)
                {
                    if(i+dir[d][0]>=0 && i+dir[d][0]<n && j+dir[d][1]>=0 && j+dir[d][1]<n)
                    {

                        que.addLast(new Pair(i+dir[d][0] ,j+dir[d][1] , (p*(1.0/8.0)) ) );
                    }
                }
            }
        }
        double ans=0;
        while(que.size()>0)
        {
            ans+=(que.removeFirst().p);
        }
        return ans;
    }

    // memorization 
    // works better
    private static int[][]dir = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    private static double[][][] dp;
    public static double knightProbability_03(int N, int K, int r, int c) {
        dp = new double[N][N][K + 1];
        return find(N,K,r,c);
    }
    public static double find(int N,int K,int r,int c){
        if(r < 0 || r > N - 1 || c < 0 || c > N - 1) return 0;
        if(K == 0)  return 1;
        if(dp[r][c][K] != 0) return dp[r][c][K];
        double rate = 0;
        for(int i = 0;i < dir.length;i++)   rate += 0.125 * find(N,K - 1,r + dir[i][0],c + dir[i][1]);
        dp[r][c][K] = rate;
        return rate;
    }
    public static void main(String args[])
    {
        int n=3;
        int k=2;
        System.out.println(knightProbability(n,k,0,0));
        System.out.println(knightProbability_02(n,k,0,0));
        System.out.println(knightProbability_03(n,k,0,0));

    }
}