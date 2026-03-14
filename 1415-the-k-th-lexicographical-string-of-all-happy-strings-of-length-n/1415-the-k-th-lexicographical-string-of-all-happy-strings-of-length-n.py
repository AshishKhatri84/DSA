class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        total = 3 * (1 << (n - 1))
        if k > total:
            return ""
        ans = []
        prev = ""
        for i in range(n):
            for ch in ['a', 'b', 'c']:
                if ch == prev:
                    continue
                remaining_len = n - i - 1
                cnt = 1 << remaining_len  
                if k > cnt:
                    k -= cnt
                else:
                    ans.append(ch)
                    prev = ch
                    break
        return "".join(ans)