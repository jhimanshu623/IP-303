#include<iostream>
#include<vector>
#include<climits>
#include<unordered_map>
using namespace std;

bool isReflected(vector<vector<int>> &points) {
    int l=INT_MAX;
    int r=INT_MIN;
    unordered_map<string,bool> map;
    for(int i=0;i<points.size();i++)
    {
        l=min(l,points[i][0]);
        r=max(r,points[i][0]);
        string s=to_string(points[i][0])+"*"+to_string(points[i][1]);
        map[s]=true;
    }
    double mid=l + ((r-l)*1.0)/2;
    for(int i=0;i<points.size();i++)
    {
        int pos=points[i][0];
        string s=to_string(pos)+"*"+to_string(points[i][1]);
        if(map.count(s)==0)
            continue;
        if(pos==mid)
            map.erase(s);
        else
        {
            int x2=2*mid-pos;
            string mi=to_string(x2)+"*"+to_string(points[i][1]);
            if(map.count(mi)==0)
                return false;
            map.erase(s);
            map.erase(mi);
        }
    }
    return true;
}

int main(int args,char** argv)
{
    vector<vector<int>> points={
        {0,0},
        {1,0}
    };
    cout<<boolalpha<<isReflected(points);
    return 0;
}