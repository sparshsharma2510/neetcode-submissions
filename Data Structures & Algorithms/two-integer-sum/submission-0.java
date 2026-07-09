class Solution {
    public int[] twoSum(int[] nums, int target) {
        // cases:
        // [3,4,5,6] target 2 output ?
        // [3] target 3 output?
        // 

        // brute: O(n^2)
        // better: sort and then use two pointers O(nlogn)
        // optimal: hashmap (inital tc 1 but large input makaes it n)
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            map.put(target-nums[i], i);
        }

        return new int[]{};

    }
}
