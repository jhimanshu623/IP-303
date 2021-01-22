import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class p2 {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<wall.size();i++)
        {
            int ps=0;
            for(int j=0;j<wall.get(i).size()-1;j++)
            {
                ps+=wall.get(i).get(j);
                map.put(ps,map.getOrDefault(ps,0)+1);
            }
        }
        int n=wall.size();
        int ans=n;
        for(int val:map.keySet())
        {
            int cw=n-map.get(val);
            if(cw<ans)
                ans=cw;
        }
        return ans;
    }
    public static void main(String[] args) {
        List<List<Integer>> wall=new ArrayList<>();
        wall.add(new ArrayList<>(Arrays.asList(1,2,2,1)));
        wall.add(new ArrayList<>(Arrays.asList(3,1,2)));
        wall.add(new ArrayList<>(Arrays.asList(1,3,2)));
        wall.add(new ArrayList<>(Arrays.asList(2,4)));
        wall.add(new ArrayList<>(Arrays.asList(3,1,2)));
        wall.add(new ArrayList<>(Arrays.asList(1,3,1,1)));
        System.out.println(leastBricks(wall));
    }
}