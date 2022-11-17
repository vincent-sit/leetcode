package q540;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r && r < nums.length) {
            int mid = (r - l) / 2 + l;

            if (mid == 0 || mid == nums.length - 1)
                return nums[mid];

            if (nums[mid - 1] == nums[mid]) {
                if ((mid + 1) % 2 == 0) {
                    l = mid + 1;
                } else {
                    r = mid - 2;
                }
            } else {
                if (nums[mid + 1] == nums[mid]) {
                    if ((mid) % 2 != 0)
                        r = mid - 1;
                    else
                        l = mid + 2;
                } else {
                    return nums[mid];
                }
            }
        }
        return 0;
    }
}