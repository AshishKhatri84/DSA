class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }
        
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n; 
            while (!stack.isEmpty() && arr[currentIndex] > arr[stack.peek()]) {
                int index = stack.pop();
                result.set(index, arr[currentIndex]); 
            }
            if (i < n) {
                stack.push(currentIndex);
            }
        }
        return result;
    }
}