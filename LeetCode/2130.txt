class Solution {
  ListNode l;
  int max = 0;

  private int helper(ListNode node) {
    if (node.next == null) return node.val;

    var r = helper(node.next);
    if (r == -1) return r;

    max = Math.max(max, l.val + r);
    l = l.next;

    return l == node ? -1 : node.val; 
  }

  public int pairSum(ListNode head) {
    l = head;
    helper(head);

    return max;
  }
}