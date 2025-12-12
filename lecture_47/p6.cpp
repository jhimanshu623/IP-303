int Solution::paint(int A, int B, vector<int> &C) {
    long long int min_time=0;
    long long int max_time=0;
    for(long long int val:C)
    {
        min_time=max(min_time,val);
        max_time+=val;
    }
    long long int l=0;
    long long int h=max_time;
    long long int ans=0;
    while(l<=h)
    {
        long long int mid=(l+h)/2;
        long long int temp=0;
        int pr=1;
        for(int val:C)
        {
            if(temp+val > mid)
            {
                pr++;
                temp=0;
            }
            temp+=val;
        }
        if(pr <= A)
        {
            ans=mid;
            h=mid-1;
        }
        else
        {
            l=mid+1;
        }
    }
    return (ans*B)%10000003;
}
