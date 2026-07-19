class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n-2; i++){
            int j = i+1;
            int k = n-1;
            while(j < k){
                int currSum = nums[i]+nums[j]+nums[k];

                if(currSum == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j++]);
                    triplet.add(nums[k--]);

                    ans.add(triplet);
                    while(j < k && nums[j] == nums[j-1])
                        j++;
                    while(j < k && nums[k] == nums[k+1])
                        k--;
                }
                else if(currSum < 0){
                    j++;
                    while(j < k && nums[j] == nums[j-1])
                        j++;
                }
                else {
                    k--;
                    while(j < k && nums[k] == nums[k+1])
                        k--;
                }
            }
            while(i < n-2 && nums[i] == nums[i+1])
                i++;
        }
        
        return ans;
    }
}
