package topic.linkedlist.medium;

public class ReverseLinkedList {

    //Iterative
    public ListNode reverseList(ListNode head) {
        ListNode node = head;

        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    //Recursive
//I did faith, that I will twist the head, means I will do node.next = prev for only the front value, and then call method for the following subsequent and it will do
    //here what iam doing is iam solving for first 2 and assuming next will get solved by their own
    public ListNode reverseListRecursion(ListNode head) {

        return reverseLLDoubleParam(null, head);


    }

    private ListNode reverseLLDoubleParam(ListNode prev, ListNode node) {
        if (node == null)
            return prev;

        ListNode temp = node.next;

        node.next = prev;
        prev = node;
        node = temp;

        return reverseLLDoubleParam(prev, node);
    }

    //Single Param, we do not need prev, we just take node, and node.next, and work on this pair
    private ListNode reverseLL(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode newHead = reverseLL(node.next);

        ListNode front = node.next;
        front.next = node;
        node.next = null;
        //prev = node;
        //node = temp;

        return newHead;
    }
}
