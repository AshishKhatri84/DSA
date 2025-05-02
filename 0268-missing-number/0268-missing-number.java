class Solution {
    public int missingNumber(int[] nums) {
        int r = nums.length;
        for (int i = 0; i < nums.length; i++) {
            r += i - nums[i];
        }   
        return r;       
    }
}