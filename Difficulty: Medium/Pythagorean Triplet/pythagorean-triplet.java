import java.util.HashSet;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        // Step 1: Square all elements and store in array + HashSet
        long[] squares = new long[n];
        HashSet<Long> squareSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            squares[i] = 1L * arr[i] * arr[i];
            squareSet.add(squares[i]);
        }

        // Step 2: Try every pair (i, j) and check if their sum exists in set
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = squares[i] + squares[j];
                if (squareSet.contains(sum)) {
                    return true; // Found a² + b² = c²
                }
            }
        }

        return false;
    }
}
