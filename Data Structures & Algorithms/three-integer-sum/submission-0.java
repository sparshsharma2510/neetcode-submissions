class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    int currSum = nums[i]+nums[j]+nums[k];
                    if(currSum == 0){
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);

                        ans.add(triplet);
                    }

                    while(k < n-1 && nums[k] == nums[k+1])
                        k++;
                }
                while(j < n-1 && nums[j] == nums[j+1])
                    j++;
            }
            while(i < n-2 && nums[i] == nums[i+1])
                i++;
        }
        
        return ans;
    }
}
