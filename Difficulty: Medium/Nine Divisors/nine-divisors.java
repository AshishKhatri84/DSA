import java.util.ArrayList;

class Solution {
    public static int countNumbers(int n) {
        ArrayList<Integer> primes = sieveOfEratosthenes((int) Math.sqrt(n));
        int count = 0;

        // Count numbers of the form p^8
        for (int prime : primes) {
            long power8 = (long) Math.pow(prime, 8);
            if (power8 <= n) {
                count++;
            } else {
                break;
            }
        }

        // Count numbers of the form p1^2 * p2^2
        int size = primes.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                long power2Product = (long) Math.pow(primes.get(i), 2) * (long) Math.pow(primes.get(j), 2);
                if (power2Product <= n) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    private static ArrayList<Integer> sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= limit; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
