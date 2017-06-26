package trapping_rain_water;

/**
 * Created by Xiaotian on 6/26/17.
 */
public class Solution {
    // tag: prefix max, suffix max
    // time: O(n)
    // space: O(n)
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int[] leftMax = new int[height.length]; // prefixMax, including self
        int[] rightMax = new int[height.length]; // suffixMax, including self
        int n = height.length;
        for (int i = 0; i < n; i++) {
            leftMax[i] = (i == 0 ? height[i] : Math.max(leftMax[i - 1], height[i]));
        }
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = (i == n - 1 ? height[i] : Math.max(rightMax[i + 1], height[i]));
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}
