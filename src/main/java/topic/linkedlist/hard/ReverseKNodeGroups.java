package topic.linkedlist.hard;

import topic.linkedlist.ListNode;

public class ReverseKNodeGroups {

    public ListNode reverseKGroup(ListNode head, int k) {

        //Easy Question, have 2 pointers, track a list of size K, reverse it join it back into LL and move ahead and get next LL of size K
        //Take care of joining the next of previous with the rotated head of current LL, and join the next to rotated tail of LL
        //Scenarios where prev can be null
        //Scenarios where next can be null
        //Scenarios where both have value


        ListNode currHead = head;
        ListNode temp = head;
        int currSize = 1;
        ListNode prev = null;
        while (temp != null) {

            if (currSize == k) {
                ListNode tempSave = currHead;
                ListNode tempNext = temp.next;
                temp.next = null;
                ListNode headNew = reverseNode(currHead);
                temp = tempSave;
                temp.next = tempNext;
                currHead = tempNext;
                if (prev != null) {
                    prev.next = headNew;
                } else {
                    head = headNew;
                }
                prev = temp;
                currSize = 0;
            }
            temp = temp.next;
            currSize++;
        }

        return head;

    }

    private ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseNode(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

}
