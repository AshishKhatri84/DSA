class Solution {
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactors = primeFactorization(k);
        
        int maxPower = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int exponent = entry.getValue();
            int countInFactorial = countPrimeInFactorial(n, prime);
            int maxXForThisPrime = countInFactorial / exponent;
            maxPower = Math.min(maxPower, maxXForThisPrime);
        }
        
        return maxPower;
    }
    
    private Map<Integer, Integer> primeFactorization(int k) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            factors.put(k, factors.getOrDefault(k, 0) + 1);
        }
        return factors;
    }
    
    private int countPrimeInFactorial(int n, int prime) {
        int count = 0;
        long power = prime;
        while (power <= n) {
            count += n / power;
            power *= prime;
        }
        return count;
    }
}