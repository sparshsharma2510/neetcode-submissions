class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int el: nums)
            map.put(el, map.getOrDefault(el,0)+1);
        
        int[] topKFrequentElems = new int[k];
        while(k-- > 0){
            int maxKey = 0, maxFreq = 0;
            for(int key: map.keySet()){
                int keyFreq = map.get(key);

                if(maxFreq < keyFreq){
                    maxFreq = keyFreq;
                    maxKey = key;
                }
            }
            map.remove(maxKey);
            topKFrequentElems[k] = maxKey;
        }
        return topKFrequentElems;
    }
}
