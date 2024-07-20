package topic.linkedlist.medium;

public class SortLLMergeSort {

    //Brute is populating an array sorting it then using it to re populate LL
    //Optimised is merge SOrt

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        //Finding Mid Node, dividing in half, divide n conquer, using tortoise hare method
        ListNode midNode = findMidNode(head);
        //Taking the right half
        ListNode temp = midNode.next;
        //Seggregating so left doesnt connect to right
        midNode.next = null;

        //This was my mistake we were sorting the left half and right half but was not storing them, instead was passing the older left and right head
        //So fixed this by passing the result of each as method argument
        // sortList(head);
        // sortList(temp);
        //remember for leftHalf head pass head , for rightHalf head pass temp i.e mid.next;
        return mergeNode(sortList(head), sortList(temp));

    }

    private ListNode findMidNode(ListNode head) {
        ListNode slowP = head;
        ListNode fastP = head;

        while (fastP.next != null && fastP.next.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        return slowP;
    }

    private ListNode mergeNode(ListNode headLeft, ListNode headRight) {
        ListNode leftP = headLeft;
        ListNode rightP = headRight;
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        while (leftP != null && rightP != null) {

            if (leftP.val < rightP.val) {
                dummy.next = leftP;
                dummy = dummy.next;
                leftP = leftP.next;
            } else {
                dummy.next = rightP;
                dummy = dummy.next;
                rightP = rightP.next;
            }

        }

        while (leftP != null) {
            dummy.next = leftP;
            dummy = dummy.next;
            leftP = leftP.next;

        }
        while (rightP != null) {
            dummy.next = rightP;
            dummy = dummy.next;
            rightP = rightP.next;

        }

        return dummyHead.next;
    }
}
