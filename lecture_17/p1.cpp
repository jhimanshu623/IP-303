#include<iostream>
using namespace std;

bool isLongPressedName(string name, string typed) {
    int i=0;
    int j=0;
    while(i<name.length() && j<typed.length())
    {  
        if(name[i]==typed[j])
        {
            i++;
            j++;
        }
        else
        {
            if(j-1>=0 && typed[j]==typed[j-1])
                j++;
            else
                return false;
        }
    }
    if(i!=name.length())
        return false;
    while(j!=typed.length())
    {
        if(j-1>=0 && typed[j]==typed[j-1])
            j++;
        else
            return false;
    }
    return true;
}
int main(int args,char** argv)
{
    string name="alex";
    string typed="aaleex";
    cout<<isLongPressedName(name,typed);
    return 0;
}