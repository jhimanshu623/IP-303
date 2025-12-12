public class p5 {
    public static boolean isVowel(char c)
    {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||
           c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
            return true;
        return false;
    }
    public static String reverseVowels(String s) {
        StringBuilder str=new StringBuilder(s);
        int i=0;
        int j=str.length()-1;
        while(i<j)
        {
            if(!isVowel(str.charAt(i)))
                i++;
            if(!isVowel(str.charAt(j)))
                j--;
            if(isVowel(str.charAt(i)) && isVowel(str.charAt(j)))
            {
                char c=str.charAt(i);
                str.setCharAt(i,str.charAt(j));
                str.setCharAt(j,c);
                i++;
                j--;
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        String s="leetcode";
        System.out.println(reverseVowels(s));
    }
}