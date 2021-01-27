#include<iostream>
#include<vector>
#include<climits>
using namespace std;

void reverse(string& str,int s,int e)
{
    while(s<e)
    {
        swap(str[s++],str[e--]);
    }
}

int nextGreaterElement(int n) {
    string s=to_string(n);
    int i=s.length()-1;
    while(i>0)
    {
        if(s[i]-'0'>s[i-1]-'0')
            break;
        i--;
    }
    if(i==0)
        return -1;
    int fpos=i-1;
    while(i<s.length())
    {
        if(s[fpos]-'0'<s[i]-'0')
            i++;
        else
            break;
    }
    int spos=i-1;
    swap(s[fpos],s[spos]);
    reverse(s,fpos+1,s.length()-1);
    return stol(s)>INT_MAX?-1:stol(s);  // because of this case 1999999999 
}

int main(int args,char** argv)
{
    int n=21;
    cout<<nextGreaterElement(n);
    return 0;
}