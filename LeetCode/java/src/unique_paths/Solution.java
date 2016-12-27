package unique_paths;

/**
 * Created by Xiaotian on 12/26/16.
 */
// tag: dp
// time: O(mn)
// space: O(mn)
public class Solution {
    public int uniquePaths(int m, int n) {
        // dp[i][j]: uniquePaths from top-left to i-j grid
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

// same as SolutionI, init outside for loop
// tag: dp
// time: O(mn)
// space: O(mn)
class SolutionII {
    public int uniquePaths(int m, int n) {
        // dp[i][j]: uniquePaths from top-left to i-j grid
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

// dp[i][j] = dp[i-1][j] + dp[i][j-1]. Can save space by using dp[j] = dp[j-1] + dp[j].
// tag: dp
// time: O(mn)
// space: O(n)
class SolutionIII {
    public int uniquePaths(int m, int n) {
        // dp[j]: uniquePaths from top-left to i-j grid
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                }
                else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
