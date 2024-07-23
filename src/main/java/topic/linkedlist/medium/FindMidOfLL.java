package topic.linkedlist.medium;

import topic.linkedlist.ListNode;

public class FindMidOfLL {

    //Brute - > do 1 iteration till end of node, return counter
    //Optimised -> tortoise hare method, 1 fast pointer i.e fastPointer = node.next.next, 1 Slow Pointer = node.next;
    //When fast pointer reaches end we are at mid
    //Take care in case of even and odd, in even we return slow.next, and in odd its slow only

    /**
     * Definition for singly-linked list.
     */


    public ListNode middleNode(ListNode head) {
        int counter = 1;
        ListNode temp = head.next;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        if (counter == 1) {
            return head;
        }
        temp = head.next;
        for (int i = 1; i < counter / 2; i++) {
            temp = temp.next;
        }
        return temp;

    }


}
