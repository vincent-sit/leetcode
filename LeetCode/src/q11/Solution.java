package q11;

public class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int w = r - l;
            if (height[l] > height[r]) {
                maxArea = Math.max(maxArea, height[r] * w);
                r--;
            } else {
                maxArea = Math.max(maxArea, height[l] * w);
                l++;
            }
        }
        return maxArea;
    }
}