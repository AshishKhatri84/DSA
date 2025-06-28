class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        Arrays.sort(b);
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int num : a) {
            int count = upperBound(b, num);
            result.add(count);
        }
        
        return result;
    }
    
    private static int upperBound(int[] b, int num) {
        int left = 0, right = b.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (b[mid] <= num) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }
        return left;
    }
}