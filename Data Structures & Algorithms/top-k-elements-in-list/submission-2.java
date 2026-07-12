class Pair{
    int element;
    int freq;

    Pair(int element, int freq){
        this.element = element;
        this.freq = freq;
    }
}

class Solution {
    public int[] naiveSolution(int[] nums, int k){
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

    public int[] betterSolution(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();

        for(int el: nums)
            map.put(el, map.getOrDefault(el, 0)+1);
        
        Queue<Pair> pq = new PriorityQueue<>((a,b)->{
            return b.freq-a.freq;
        });

        for(int elem: map.keySet())
            pq.offer(new Pair(elem, map.get(elem)));
        
        int[] topKFreqElem = new int[k];
        while(k-- > 0)
            topKFreqElem[k] = pq.poll().element;

        return topKFreqElem;
    }

    public int[] topKFrequent(int[] nums, int k) {
        // Build CountMap
        Map<Integer, Integer> map = new HashMap<>();

        for(int el: nums)
            map.put(el, map.getOrDefault(el, 0)+1);
        
        List<List<Integer>> bucket = new ArrayList<>();

        for(int i = 0; i <= nums.length; i++)
            bucket.add(new ArrayList<>());

        for(int elem: map.keySet())
            bucket.get(map.get(elem)).add(elem);
        
        int[] topK = new int[k];
        for(int i = nums.length; k > 0; i--){
            if(bucket.get(i).size() > 0){
                List<Integer> freqBucket = bucket.get(i);

                for(int el: freqBucket){
                    topK[--k] = el;
                    if(k == 0)
                        return topK;
                }
            }
        }
        return topK;
    }
}
