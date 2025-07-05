import java.util.Stack;

class Solution {
    public int maxSum(int arr[]) {
        int n = arr.length;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];

        // Initialize nextSmaller and prevSmaller
        for (int i = 0; i < n; i++) {
            nextSmaller[i] = n; // Default to n (out of bounds)
            prevSmaller[i] = -1; // Default to -1 (out of bounds)
        }

        // Find next smaller elements
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        // Clear the stack to reuse it
        stack.clear();

        // Find previous smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                prevSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        int maxScore = 0;

        // Calculate the maximum sum of smallest and second smallest
        for (int i = 0; i < n; i++) {
            // Find the range of valid second smallest elements
            int leftBound = prevSmaller[i] + 1; // Start after the previous smaller
            int rightBound = nextSmaller[i]; // End before the next smaller

            // Iterate through the range to find the second smallest
            for (int j = leftBound; j < rightBound; j++) {
                if (j != i) { // Ensure we are not considering the same element
                    maxScore = Math.max(maxScore, arr[i] + arr[j]);
                }
            }
        }

        return maxScore;
    }
}
