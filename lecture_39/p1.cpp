class Solution {
public:
    unordered_map<int,int> par;
    unordered_map<int,int> rank;
    int set=0;
    int find(int x)
    {
        if(par[x]==x)
            return x;
        int px=find(par[x]);
        par[x]=px;
        return px;
    }
    void merge(int x,int y)
    {
        int xl=find(x);
        int yl=find(y);
        if(xl!=yl)
        {
            if(rank[xl]<rank[yl])
                par[xl]=yl;
            else if(rank[yl]<rank[xl])
                par[yl]=xl;
            else
            {
                par[xl]=yl;
                rank[yl]++;
            }
            set--;
        }
    }
    int removeStones(vector<vector<int>>& stones) {
        for(int i=0;i<stones.size();i++)
        {
            int r=stones[i][0];
            int c=-stones[i][1]-1;
            if(par.count(r)==0)
            {
                par[r]=r;
                rank[r]=1;
                set++;
            }
            if(par.count(c)==0)
            {
                par[c]=c;
                rank[c]=1;
                set++;
            }
            merge(r,c);
        }
        return stones.size()-set;
    }
};