class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();

        if(n != t.length())
            return false;

        int[] sCharacterFrequency = new int[26];
        int[] tCharacterFrequency = new int[26];

        for(int i = 0; i < n; i++){
            sCharacterFrequency[s.charAt(i) - 'a']++;
            tCharacterFrequency[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(sCharacterFrequency[i] != tCharacterFrequency[i])
                return false;
        }
        return true;
    }
}
