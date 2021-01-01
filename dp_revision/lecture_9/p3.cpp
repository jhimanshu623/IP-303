#include <iostream>
using namespace std;

int solve(string s)
{
    int a=0;
    int b=0;
    int c=0;
    for(int i=0;i<s.length();i++)
    {
        char ch=s[i];
        if(ch=='a')
            a=2*a+1;
        else if(ch=='b')
            b=2*b+a;
        else
            c=2*c+b;
    }
    return c;
}

int main() {
    int t;
    cin>>t;
    while(t-->0)
    {
        string s;
        cin>>s;
        int res=solve(s);
        cout<<res<<endl;
    }
	return 0;
}