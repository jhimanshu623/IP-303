#include<iostream>
#include<vector>

using namespace std;

bool isPalin(string s,int st,int e)
{
    int i=st;
    int j=e;
    while(i<j)
    {
        if(s[i]!=s[j])
            return false;
        i++;
        j--;
    }
    return true;
}
bool validPalindrome(string s) {
    bool res=false;
    int i=0;
    int j=s.length()-1;
    while(i<j)
    {
        if(s[i]!=s[j])
        {
            res=isPalin(s,i,j-1) || isPalin(s,i+1,j);
            return res;
        }
        i++;
        j--;
    }
    return true;
}
int main(int args,char** argv)
{
    string s="abca";
    cout<<boolalpha<<validPalindrome(s);
    return 0;
}