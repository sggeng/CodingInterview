package perfect_squares;

/**
 * Created by Xiaotian on 12/29/16.
 */
// tag: dp
// time: O(n*sqrt(n))
// space: O(n)
public class Solution {
    public int numSquares(int n) {
        // dp[i]: minNumSquares of i
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int sqrt = 1; sqrt*sqrt <= i; sqrt++) {
                dp[i] = Math.min(dp[i], dp[i - sqrt*sqrt] + 1);
            }
        }
        return dp[n];
    }
}
