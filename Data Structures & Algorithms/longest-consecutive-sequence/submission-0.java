class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int el: nums)
            set.add(el);

        int longestSeq = 0;
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i]-1)){
                // this is a start of sequence
                int seqLen = 1;
                int currSeqNum = nums[i];
                while(set.contains(currSeqNum+1)){
                    currSeqNum++;
                    seqLen++;
                }
                longestSeq = Math.max(longestSeq, seqLen);
            }
        }

        return longestSeq;
    }
}
