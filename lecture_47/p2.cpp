class Solution {
public:
    int shipWithinDays(vector<int>& wt, int d) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int mw=0;
        int sum=0;
        for(int i:wt){
            mw=max(mw,i);
            sum+=i;
        }
        int l=mw;
        int h=sum;
        int ans=-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            
            int temp=0;
            int rd=1;
            for(int i:wt)
            {
                if(temp+i > mid)
                {
                    rd++;
                    temp=0;
                }
                temp+=i;
            }
            
            if(rd > d)
            {
                l=mid+1;
            }
            else if(rd<=d)
            {
                ans=mid;
                h=mid-1;
            }
        }
        return ans;
    }
};