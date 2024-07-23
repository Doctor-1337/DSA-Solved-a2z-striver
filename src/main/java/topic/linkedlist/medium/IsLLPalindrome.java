package topic.linkedlist.medium;

import topic.linkedlist.ListNode;

public class IsLLPalindrome {

//    https://leetcode.com/problems/palindrome-linked-list/

    public boolean isPalindrome(ListNode head) {
        ListNode slowP = head;
        ListNode fastP = head;
        if (head == null || head.next == null)
            return true;
        //We split LL in half
        while (fastP.next != null && fastP.next.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }


        //We reverse the right half
        ListNode revHead = reverse(slowP.next);
        ListNode head1Temp = head;
        ListNode head2Temp = revHead;
        boolean isPalindrome = true;

        //We not check if left half and reversed Right half are equals or not i.e palindrome or not
        while (head1Temp != null && head2Temp != null) {
            if (head1Temp.val != head2Temp.val) {
                isPalindrome = false;
                break;
            }
            head1Temp = head1Temp.next;
            head2Temp = head2Temp.next;
        }
        //Reverse back to get original LL
        reverse(revHead);

        return isPalindrome;
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode newHead = reverse(node.next);

        ListNode front = node.next;
        front.next = node;
        node.next = null;
        return newHead;
    }

}
