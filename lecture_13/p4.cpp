#include <iostream>
#include<unordered_map>
using namespace std;

int longestLength(string s)
{
    unordered_map<char,int> map1;
    int st=0;
    int end=-1;
    int ans=0;
    // int n=s.length();
    while(end < s.length()-1)
    {
        end++;
        char ch=s[end];
        map1[ch]++;
        if(map1[ch]==1){
            ans=max(ans,end-st+1);
        }
        else
        {
            while(map1[ch]>1)
            {
                map1[s[st]]--;
                st++;
            }
        }
    }
    return ans;
}
int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        string s;
        cin>>s;
        cout<<longestLength(s)<<"\n";
    }
	return 0;
}