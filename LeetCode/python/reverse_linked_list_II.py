# Reverse a linked list from position m to n. Do it in-place and in one-pass.

# For example:
# Given 1->2->3->4->5->NULL, m = 2 and n = 4,

# return 1->4->3->2->5->NULL.

# Note:
# Given m, n satisfy the following condition:
# 1 ≤ m ≤ n ≤ length of list.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param m, an integer
    # @param n, an integer
    # @return a ListNode
    def reverseBetween_1(self, head, m, n):
        if head == None: return
        helper = ListNode(0); helper.next = head
        prev = helper
        for i in xrange(1, m):
            prev = prev.next
        # start: m.prev; end: m
        start = prev
        end = prev.next
        # prev: m; curr: m.next
        prev, curr = prev.next, prev.next.next
        for i in xrange(m, n):
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
        # prev: n; curr: n.next
        start.next = prev
        end.next = curr
        return helper.next
                