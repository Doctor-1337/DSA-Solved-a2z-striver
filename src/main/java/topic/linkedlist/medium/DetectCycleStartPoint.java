package topic.linkedlist.medium;

import topic.linkedlist.ListNode;

import java.util.*;

public class DetectCycleStartPoint {

    //Return where first element is same
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> map = new HashSet<>();

        while (head != null) {
            if (map.contains(head)) {
                return head;
            }
            map.add(head);
            head = head.next;

        }
        return null;
    }

    public ListNode detectCycleOptimised(ListNode head) {
        ListNode slowP = head;
        ListNode fastP = head;

        //Tortoise Hare
        //If loop present theyu will collide somewhere
        //When collided, take slowP  to head,
        //Then increment both by 1 again, till they meet, this is our starting point
        //Now why does this happen, suppose slowPointer is at L1 from  start point where L1 is the start of Loop, so
        //As fast pointer is going 2 x speed of slow it will be at L2 which will be 2L1 from start,
        //Now we need to make them collide first, suppose when slowP is at start of circle and fastP is at L1 from slowP (as slowP as at L1 and fastP is at 2x L1)
        //Now we move both again, fastP moves by 2x ans slow by 1x, fastP needs to cover d distance to catchup to slowP after taking full round,
        //slowP moving away from fastP at 1x speed, where fastP moving towards by 2x so relative speed = 1x
        //time taken to cover distance d with 1x is = d only
        //This means when they meet again it will be at d distance, so the other distance must be L1, as L1 + d = loop length
        //so now we move fastP which is at L1 place from start of loop., and place slowPointer at 0 which is L1 dtsance from start of circle
        //We move both by 1 till they collide i.e both cover L1 distance
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;

            if (slowP == fastP) {
                slowP = head;
                while (slowP != fastP) {
                    slowP = slowP.next;
                    fastP = fastP.next;
                }
                return slowP;
            }
        }
        return null;
    }
}
