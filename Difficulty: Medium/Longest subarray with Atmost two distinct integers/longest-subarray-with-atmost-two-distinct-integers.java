class Solution {
    public int totalElements(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < arr.length; right++) {
            countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);

            while (countMap.size() > 2) {
                countMap.put(arr[left], countMap.get(arr[left]) - 1);
                if (countMap.get(arr[left]) == 0) {
                    countMap.remove(arr[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}