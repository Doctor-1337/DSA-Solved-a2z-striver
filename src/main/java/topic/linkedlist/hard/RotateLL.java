package topic.linkedlist.hard;

import topic.linkedlist.ListNode;

public class RotateLL {
    // Time complexity - > O N for finding Length, O N for finding Kth from last, 3N for Reversal 3 times
    //Edge case what if K is greater than size, we need to mod it to size, for that we need the size;
    public ListNode rotateRight(ListNode head, int k) {
        //We do just like array rotation, rev 1 half till 0 to n-k, rotate other half from n-k to n
        //Then rotate whole list


        //Find K th from last
        if (head == null || head.next == null)
            return head;
        ListNode slowP = head;
        ListNode fastP = head;
        int counter = 0;
        int sizeLL = getSizeOfLL(head);
        k = k % sizeLL;
        while (fastP.next != null) {
            if (counter >= k) {
                slowP = slowP.next;
            }
            fastP = fastP.next;
            counter++;
        }
        //Now head -> head of left Half LL
        // slowP -> tail of leftHalf LL
        //slowP.next -> head of rightHalf LL
        //fastP -> tail of rightHalf LL

        ListNode rightHalfHead = slowP.next;
        //Seggregating left half and right half
        slowP.next = null;

        reverseNode(head);
        head.next = reverseNode(rightHalfHead);

        return reverseNode(slowP);


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

    private int getSizeOfLL(ListNode head) {
        int counter = 0;
        ListNode temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;

        }
        return counter;
    }

    //This takes multiple iteration we can do better as its LL and we can modify from in between, WE will do the same approach but we dont need to rev,
    // we just take the right part and append to front.
    //We can save the time taken to reverse
    //Take care of edge case where k == 0; we might return emprt list according to logic so handle it seperately
    //Both when k == 0, or k%ssize == 0 just return head, no  need for rotation.
    public ListNode rotateRightOptimised(ListNode head, int k) {
        //We do just like array rotation, rev 1 half till 0 to n-k, rotate other half from n-k to n
        //Then rotate whole list

        if (head == null || head.next == null)
            return head;


        int sizeLL = getSizeOfLL(head);


        //Handle overflow , K > size
        k = k % sizeLL;

        //No rotation Needed
        if (k == 0)
            return head;


        //Find K th from last
        ListNode slowP = head;
        ListNode fastP = head;
        int counter = 0;

        while (fastP.next != null) {
            if (counter >= k) {
                slowP = slowP.next;
            }
            fastP = fastP.next;
            counter++;
        }
        //Now head -> head of left Half LL
        // slowP -> tail of leftHalf LL
        //slowP.next -> head of rightHalf LL
        //fastP -> tail of rightHalf LL

        ListNode rightHalfHead = slowP.next;
        //Seggregating left half and right half
        slowP.next = null;
        fastP.next = head;
        // reverseNode(head);
        //head.next = reverseNode(rightHalfHead);

        return rightHalfHead;


    }
}
