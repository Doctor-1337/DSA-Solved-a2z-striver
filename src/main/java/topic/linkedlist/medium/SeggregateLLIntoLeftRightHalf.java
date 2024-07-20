package topic.linkedlist.medium;

public class SeggregateLLIntoLeftRightHalf {

    //Put any condition inside if condition it will work,
    //take care of edge cases such as when left half is empty, right half is empty, all is empty, only one element
    
    public ListNode oddEvenList(ListNode head) {

        ListNode odd = null;
        ListNode even = null;
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode temp = head;
        head = null;
        ListNode prev = null;
        ListNode newHead = null;
        int idx = 1;
        while (temp != null) {

            if (idx % 2 == 0) {
                if (even == null) {
                    head = temp;
                    even = temp;
                } else {
                    even.next = temp;
                    even = even.next;
                }
            } else {
                if (odd == null) {
                    odd = temp;
                    newHead = odd;
                } else {
                    odd.next = temp;
                    prev = odd;
                    odd = odd.next;
                }
            }
            temp = temp.next;
            idx++;
        }
        if (even != null)
            even.next = null;
        if (prev != null) {
            odd.next = head;
            return newHead;
        } else {
            return head;
        }

    }
}
