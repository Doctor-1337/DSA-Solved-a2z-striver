package topic.linkedlist.medium;

import topic.linkedlist.ListNode;

public class DetectCycle {

    //Optimised -> O N and space is O 1
    //brute force is O N and space O N, as we use hashmap to store Nodes and check if any node re-appears while iterating
    public boolean hasCycle(ListNode head) {
        ListNode slowP = head;
        ListNode fastP = head;

        while (fastP != null && fastP.next != null) {
            fastP = fastP.next.next;
            slowP = slowP.next;
            if (fastP == slowP)
                return true;
        }
        return false;
    }
}
