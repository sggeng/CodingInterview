# Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

# For example,
# If n = 4 and k = 2, a solution is:

# [
#   [2,4],
#   [3,4],
#   [2,3],
#   [1,2],
#   [1,3],
#   [1,4],
# ]

class Solution:
    # @return a list of lists of integers
    def combine_1(self, n, k):
        res = []
        self.dfs(n, k, 1, [], res)
        return res

    def dfs(self, n, k, m, tmp, res):
        if k == len(tmp):
            res.append(tmp[:])
            return
        for i in range(m, n + 1):
            tmp.append(i)
            self.dfs(n, k, i + 1, tmp, res)
            tmp.pop()