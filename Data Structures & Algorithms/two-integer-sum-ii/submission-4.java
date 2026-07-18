class Solution {
    public int[] twoSumBetter(int[] numbers, int target){
        int n = numbers.length;
        for(int i = 0; i < n-1; i++){
            int start = i+1;
            int end = n-1;

            while (start <= end){
                int mid = (start+end)/2;
                int currSum = numbers[mid]+numbers[i];
                if(currSum == target)
                    return new int[]{i+1, mid+1};
                else if(currSum < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return new int[]{};
    }

    public int[] twoSumBetterTime(int[] numbers, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int n = numbers.length;
        for(int i = 0 ; i < n; i++)
            map.put(numbers[i], i);
        
        for(int i = 0; i < n; i++){
            int required = target-numbers[i];
            if(map.containsKey(required) && map.get(required) != i)
                return new int[]{i+1, map.get(required)+1};
        }
        return new int[]{};
    }
    private int[] twoSumOptimal(int[] numbers, int target){
        int i = 0, j = numbers.length-1;

        while(i<j){
            int currSum = numbers[i]+numbers[j];
            if(currSum == target)
                return new int[]{i+1, j+1};
            else if(currSum < target)
                i++;
            else
                j--;
        }

        return new int[]{};
    }

    public int[] twoSum(int[] numbers, int target) {
        return twoSumOptimal(numbers, target);
    }
}
