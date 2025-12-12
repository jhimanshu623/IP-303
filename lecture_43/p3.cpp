class Solution {
public:
    unordered_map<string,vector<string>> g;
    list<string> res;
    void dfs(string u)
    {
        while(g[u].size()>0){
            string nv=g[u][g[u].size()-1];
            g[u].pop_back();
            dfs(nv);
        }
        res.push_front(u);
    }
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        for(int i=0;i<tickets.size();i++)
        {
            string u=tickets[i][0];
            string v=tickets[i][1];
            g[u].push_back(v);
        }
        for(auto s:g)
        {   
            sort(s.second.begin(), s.second.end(), greater<string>()); 
            g[s.first]=s.second;   
        }
        dfs("JFK");
        vector<string> ans;
        for(auto const& s:res)
        {
            ans.push_back(s);
        }
        return ans;
    }
};