class Solution:
    def subarraySum(self, arr):
        n = len(arr)
        total_sum = 0
        
        for i in range(n):
            count = (i + 1) * (n - i)
            total_sum += arr[i] * count
        
        return total_sum

solution = Solution()