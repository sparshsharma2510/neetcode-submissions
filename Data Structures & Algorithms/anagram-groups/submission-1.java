class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Naive solution:
        // s1 s2 s3 ... sn
        // s1... sn -> comparing till sn O(n^2)
        // comparing algo: isAnagram(s1, s2): boolean -> O(n)

        // total TC: O(n^3)

        // Sorting Based:
        // Sort strs[]
        // anagrams will become exactly identical
        // Key (sorted string), value pairs (List of actual strigns)
        // TC O(nmlogm)

        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] sortedStringArr = strs[i].toCharArray();
            Arrays.sort(sortedStringArr);
            String anagramKey = new String(sortedStringArr);

            if(map.containsKey(anagramKey))
                map.get(anagramKey).add(strs[i]);
            else{
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                map.put(anagramKey, group);
            }
        }

        return new ArrayList<>(map.values());
    }
}
