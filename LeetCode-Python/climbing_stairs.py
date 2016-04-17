# You are climbing a stair case. It takes n steps to reach to the top.

# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

class Solution:
    # @param n, an integer
    # @return an integer

    # same as fibonacci sequence, f(n)=f(n-1)+f(n-2)
    def climbStairs_1_recursive(self, n):
        # intuitive
        if n == 1:
            return 1
        if n == 2:
            return 2
        return self.climbStairs(n - 1) + self.climbStairs(n - 2)


    def climbStairs_2_dp(self, n):
        # space complexity: O(N)
        dp = [0 for i in range(0, n+1)]
        dp[0], dp[1] = 1, 1
        for i in range(2, n+1):
            dp[i] = dp[i - 1] + dp[i - 2]
            i += 1
        return dp[n]


    def climbStairs_3_iterative(self, n):
        a, b = 1, 2
        if n == 1:
            return a
        if n == 2:
            return b
        for i in range(3, n + 1):
            result = a + b
            a = b
            b = result
        return result