class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        long totalSum = 0; 
        Stack<Integer> stack = new Stack<>();
        
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            nextSmaller[stack.pop()] = n; 
        }
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                prevSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            prevSmaller[stack.pop()] = -1; 
        }
        
        for (int i = 0; i < n; i++) {
            long leftCount = i - prevSmaller[i]; 
            long rightCount = nextSmaller[i] - i; 
            totalSum += arr[i] * leftCount * rightCount; 
        }
        
        return (int)(totalSum % 1000000007); 
    }
}