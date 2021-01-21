#include<iostream>
#include<unordered_map>
using namespace std;

// 12ms
bool isIsomorphic(string s, string t) {
    unordered_map<char,char> map1;
    unordered_map<char,char> map2;
    for(int i=0;i<s.length();i++)
    {
        if(map1.count(s[i])==0)
        {
            if(map2.count(t[i])==0){
                map1[s[i]]=t[i];
                map2[t[i]]=s[i];
            }
            else
                return false;
        }
        else
        {
            if(map1[s[i]]!=t[i])
                return false;
        }
    }
    return true;
}
// 20ms
bool isIsomorphic2(string s, string t) {
    unordered_map<char,int> map1;
    unordered_map<char,int> map2;
    for(int i=0;i<s.length();i++)
    {
        if(map1[s[i]] != map2[t[i]])
            return false;
        map1[s[i]]=i+1;
        map2[t[i]]=i+1;
    }
    return true;
}

// 4ms
bool isIsomorphic3(string s, string t) {
    int map1[256]={0};
    int map2[256]={0};
    for(int i=0;i<s.length();i++)
    {
        if(map1[s[i]] != map2[t[i]])
            return false;
        map1[s[i]]=i+1;
        map2[t[i]]=i+1;
    }
    return true;
}

int main(int args,char** argv)
{
    string s="paper";
    string t="title";
    cout<<isIsomorphic(s,t)<<endl;
    cout<<isIsomorphic2(s,t)<<endl;
    cout<<isIsomorphic3(s,t)<<endl;
    return 0;
}