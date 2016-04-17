/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReverseLinkedListII {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */

    // V1, O(n)
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null || m >= n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        ListNode premNode = head;
        ListNode mNode = head.next;

        ListNode nNode = mNode;
        ListNode postnNode = mNode.next;

        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode tmp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = tmp;
        }

        premNode.next = nNode;
        mNode.next = postnNode;

        return dummy.next;

    }
}

