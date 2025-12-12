class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double l=0;
        double h=1;
        while(true)
        {
            int p=0;
            int q=1;
            int n=arr.length;
            double mid=(l+h)/2.0;
            int count=0;
            int j=1;
            int temp=n-j;
            for(int i=0;i<n;i++)
            {
                while(j<n && arr[i] > mid*arr[j])
                {
                    j++;
                    temp--;
                }
                count+=temp;
                if(j<n && arr[i]*q > arr[j]*p)
                {
                    p=arr[i];
                    q=arr[j];
                }
            }
            if(count<k)
                l=mid;
            else if(count>k)
                h=mid;
            else
                return new int[]{p,q};
        }
    }
}



// alternative

class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        double l=0;
        double h=1;
        while(true)
        {
            int p=0;
            int q=1;
            int n=arr.size();
            double mid=(l+h)/2.0;
            int count=0;
            int j=1;
            int temp=n-j;
            for(int i=0;i<n;i++)
            {
                while(j<n && (arr[i]*1.0)/arr[j] > mid)
                {
                    j++;
                    temp--;
                }
                count+=temp;
                if(j<n && (arr[i]*1.0)/arr[j] > (p*1.0)/q)
                {
                    p=arr[i];
                    q=arr[j];
                }
            }
            if(count<k)
                l=mid;
            else if(count>k)
                h=mid;
            else
                return {p,q};
        }
    }
};