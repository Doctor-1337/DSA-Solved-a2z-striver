package topic.linkedlist.medium;

public class RemoveLastFromN {

    //brute is counting total elements then going to total-n element and removing it
    //Optim is moving a fastPointer N steps ahead
    //Then keep slowpointer at head and iterate till fastPopinter reach  null; this is our elements from Nth end posi
    //Edge case is check when remioving first ele of LL, and last Ele, also head == null and head.next == null return head;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastP = head;
        ListNode slowP = head;


        if (head.next == null)
            return null;
        for (int i = 0; i < n; i++) {

            fastP = fastP.next;

        }
        if (fastP == null) {
            ListNode temp = head.next;
            head.next = null;
            return temp;
        }

        while (fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next;
        }
        slowP.next = slowP.next.next;

        return head;
    }
}
