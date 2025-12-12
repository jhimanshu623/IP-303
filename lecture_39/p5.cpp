class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set <string> wlist;
        for(string s:wordList)
            wlist.insert(s);
        queue<string> que;
        int l=1;
        que.push(beginWord);
        wlist.erase(beginWord);
        while(que.size()>0)
        {
            int size=que.size();
            while(size-->0)
            {
                string rs=que.front();
                que.pop();
                for(int i=0;i<rs.length();i++)
                {
                    char oc=rs[i];
                    for(int j=0;j<26;j++)
                    {
                        char c='a'+j;
                        rs[i]=c;
                        //if(wlist.find(rs)!=wlist.end())     // slow
                        if(wlist.count(rs)!=0)
                        {
                            if(rs==endWord)
                                return l+1;
                            que.push(rs);
                            wlist.erase(rs);
                        }
                    }
                    rs[i]=oc;
                }
            }
            l++;
        }
        return 0;
    }
};