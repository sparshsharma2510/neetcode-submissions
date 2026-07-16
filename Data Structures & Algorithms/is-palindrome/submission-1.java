class Solution {
    private boolean isCharAlphaNum(char ch){
        return (
            (ch >= 'A' && ch <= 'Z') || 
            (ch >= 'a' && ch <= 'z') || 
            (ch >= '0' && ch <= '9')
        );
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int i = 0, j = n-1;

        while(i <= j){
            while(i <= j && !isCharAlphaNum(s.charAt(i)))
                i++;
            while(j >= i && !isCharAlphaNum(s.charAt(j)))
                j--;
            // System.out.println(s.charAt(i) + " & " + s.charAt(j));
            if(i < j && s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
