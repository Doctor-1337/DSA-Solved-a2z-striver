package topic.linkedlist.medium;

public class DeleteLLMidNode {

    //Easy tortoise hare method find mid, then at mid make it skip the next to next next, slow.next = slow.next.next;
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head.next == null)
            return null;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
