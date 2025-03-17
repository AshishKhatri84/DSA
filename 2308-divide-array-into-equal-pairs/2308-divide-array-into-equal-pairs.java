class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);

        for (int pos = 0; pos < nums.length; pos += 2) {
            if (nums[pos] != nums[pos + 1]) {
                return false;
            }
        }

        return true;
    }
}