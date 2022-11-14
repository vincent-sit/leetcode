package q1539;

public class Solution {
    public int findKthPositive(int[] arr, int k) {
        // if the missing number is less than the arr[0], that means everything from 1
        // up to (not including) arr[0] are missing
        // so we return k as it is
        if (k < arr[0])
            return k;

        // we test to see if the number of mismatched numbers at the end of the array is
        // greater than k
        // if it is not, that means the kth number lies beyond the end of the array by k
        // amount, so we add k to arr length
        int test = arr[arr.length - 1] - arr.length;
        if (k > test)
            return k + arr.length;

        int start = 0;
        int end = arr.length - 1;

        // binary search question
        while (start <= end) {
            int mid = (end + start) / 2;
            int mismatch = arr[mid] - (mid + 1);
            // if the mismatch between mid and the position is less than k, that means the
            // number we are looking for is on the right of mid
            if (mismatch < k) {
                start = mid + 1;
            }
            // otherwise, we check the number before mid to see what their mismatch number
            // is
            // if their number is also greater than k, than we know that the number we are
            // looking for is on the left
            // otherwise, compute the kth number by comparing k to prev mismatch to decide
            // how many numbers are between k and prev
            // add that difference to the prev number itself to find the missing number
            else {
                int prevMismatch = arr[mid - 1] - (mid);
                if (prevMismatch >= k) {
                    end = mid;
                } else
                    return (k - prevMismatch + arr[mid - 1]);
            }

        }
        return k;
    }
}