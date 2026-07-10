class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean[] isGrouped = new boolean[n];

        List<List<String>> groupedAnagrams = new ArrayList<>();

        for(int i = 0; i < n; i++){
            while(i < n && isGrouped[i])
                i++;
            if(i < n){
                List<String> anagrams = new ArrayList<>();
                for(int j = i; j < n; j++){
                    if(isAnagram(strs[i], strs[j])){
                        anagrams.add(strs[j]);
                        isGrouped[j] = true;
                    }
                    while(j < n-1 && isGrouped[j+1])
                        j++;
                }
                groupedAnagrams.add(anagrams);
            }
        }

        return groupedAnagrams;
    }

    public boolean isAnagram(String s1, String s2){
        int n = s1.length(), m = s2.length();
        if(n != m)
            return false;
        int[] charFreq = new int[26];

        for(int i = 0; i < n; i++){
            charFreq[s1.charAt(i) -'a']++;
            charFreq[s2.charAt(i) -'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(charFreq[i] != 0)
                return false;
        }
        return true;
    }
}
