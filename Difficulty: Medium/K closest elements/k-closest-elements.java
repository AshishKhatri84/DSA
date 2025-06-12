class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        
        int left = 0, right = n - 1, pos = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int l = pos - 1, r = pos;

        while (k > 0) {
            int leftVal = l >= 0 ? arr[l] : Integer.MIN_VALUE;
            int rightVal = r < n ? arr[r] : Integer.MIN_VALUE;

            if (l >= 0 && arr[l] == x) l--; 
            else if (r < n && arr[r] == x) r++; 
            else if (l >= 0 && (r >= n || closer(arr[l], arr[r], x))) {
                result.add(arr[l--]);
                k--;
            } else if (r < n) {
                result.add(arr[r++]);
                k--;
            } else {
                break;
            }
        }

        int[] resArr = new int[result.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = result.get(i);
        }

        return resArr;
    }

    private boolean closer(int a, int b, int x) {
        int distA = Math.abs(a - x);
        int distB = Math.abs(b - x);
        if (distA < distB) return true;
        if (distA == distB) return a > b; 
        return false;
    }
}