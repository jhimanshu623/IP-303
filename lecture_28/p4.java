import java.util.Stack;

// test case -> abacb
public class p4 {
    // 3ms
    public static String removeDuplicateLetters(String s) {
        int map[]=new int[26];
        boolean isVisited[]=new boolean[26];
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray())
            map[c-'a']++;
        for(char c:s.toCharArray())
        {
            map[c-'a']--;
            if(isVisited[c-'a']==true)
                continue;
            else
            {
                while(st.size()>0 && map[st.peek()-'a']>0 && st.peek()>c)
                {
                    char ch=st.pop();
                    isVisited[ch-'a']=false;
                }
                isVisited[c-'a']=true;
                st.push(c);
            }
        }
        StringBuilder str=new StringBuilder();
        while(st.size()>0)
            str.append(st.pop());
        str.reverse();
        return str.toString();
    }

    // 3ms
    public static String removeDuplicateLetters2(String s) {
        int map[]=new int[26];
        boolean isVisited[]=new boolean[26];
        StringBuilder st=new StringBuilder();
        for(char c:s.toCharArray())
            map[c-'a']++;
        for(char c:s.toCharArray())
        {
            map[c-'a']--;
            if(isVisited[c-'a']==true)
                continue;
            else
            {
                while(st.length()>0 && map[st.charAt(st.length()-1)-'a']>0 && st.charAt(st.length()-1)>c)
                {
                    char ch=st.charAt(st.length()-1);
                    st.deleteCharAt(st.length()-1);
                    isVisited[ch-'a']=false;
                }
                isVisited[c-'a']=true;
                st.append(c);
            }
        }
        return st.toString();
    }
    public static void main(String[] args) {
        String s="acbacb";
        System.out.println(removeDuplicateLetters(s));       
    }    
}