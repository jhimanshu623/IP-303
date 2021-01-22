
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:strs)
        {
            int num=0;
            int arr[]=new int[26];
            for(char ch:s.toCharArray())
            {
                arr[ch-'a']++;
            }
            String str=Arrays.toString(arr);
            if(map.get(str)==null)
            {
                ans.add(new ArrayList<String>(Arrays.asList(s)));
                map.put(str,ans.size()-1);
            }
            else
            {
                ans.get(map.get(str)).add(s);
            }
        }
        return ans;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:strs)
        {
            int num=0;
            int arr[]=new int[26];
            for(char ch:s.toCharArray())
            {
                arr[ch-'a']++;
            }
            String str="";
            for(int i=0;i<26;i++)
            {
                if(arr[i]>0)
                {
                    str+=(arr[i]+((char)(i+'a')+""));
                }
            }
             if(map.get(str)==null)
             {
                 ans.add(new ArrayList<String>(Arrays.asList(s)));
                 map.put(str,ans.size()-1);
             }
             else
             {
                 ans.get(map.get(str)).add(s);
             }
        }
        return ans;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:strs)
        {
            int num=0;
            int arr[]=new int[26];
            for(char ch:s.toCharArray())
            {
                arr[ch-'a']++;
            }
            String str="";
            for(int i=0;i<26;i++)
            {
                str+=(arr[i])+"_";
            }
             if(map.get(str)==null)
             {
                 ans.add(new ArrayList<String>(Arrays.asList(s)));
                 map.put(str,ans.size()-1);
             }
             else
             {
                 ans.get(map.get(str)).add(s);
             }
        }
        return ans;
    }
}


class Solution {
    int[] primes = {2, 3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(String s:strs)
        {
            int num=0;
            int arr[]=new int[26];
            long id=1;
            for(char ch:s.toCharArray())
            {
                id*=primes[ch-'a'];
            }
            if(map.get(id)==null)
            {
                ans.add(new ArrayList<String>(Arrays.asList(s)));
                map.put(id,ans.size()-1);
            }
            else
            {
                ans.get(map.get(id)).add(s);
            }
        }
        return ans;
    }
}