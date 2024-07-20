package topic.linkedlist.medium;

public class FindCollisionPoint {

    //Suppose headB is of size 10, and headA is of size 8, then we move headB two forward, then compare both heads while iterating if they ever become
    //Equals, means if they ever collide
    public ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {

        ListNode tempA = headA;
        int counterA = 0;
        ListNode tempB = headB;
        int counterB = 0;

        while (tempA != null || tempB != null) {
            if (tempA != null) {
                tempA = tempA.next;
                counterA++;
            }
            if (tempB != null) {
                tempB = tempB.next;
                counterB++;
            }
        }

        int laggingBySteps = counterB - counterA;
        tempA = headA;
        tempB = headB;
        if (counterA > counterB) {
            ListNode temp = tempA;
            tempA = tempB;
            tempB = temp;
            laggingBySteps = counterA - counterB;
        }
        int counter = 0;
        while (counter < laggingBySteps) {
            tempB = tempB.next;
            counter++;
        }
        return findListCollision(tempA, tempB);
    }

    private ListNode findListCollision(ListNode headA, ListNode headB) {
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


    public ListNode getIntersectionNodeEdgeCaseIssue(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        //So many edge cases take care
        //What if ele first is colliding and both are size 1, then it will check both ele.next == null return null
        //Also had to take care whenever we move A to B or vice versa its counted as it has been moved to next

        while (tempA != null && tempB != null) {
            if (tempB == tempA && tempA != null)
                return tempB;
            if (tempA.next == null && tempB.next == null) {
                return null;
            }

            if (tempA.next == null) {
                tempA = headB;
            } else {
                tempA = tempA.next;
            }
            if (tempB.next == null) {
                tempB = headA;
            } else {
                tempB = tempB.next;
            }


        }
        return null;

    }

    public ListNode getIntersectionNodeBest(ListNode headA, ListNode headB) {

        //In our current approach we need to handle it explicitly, take eg a case where we have l1 [1] and l2 as null
        if (headA == null || headB == null)
            return null;

        ListNode tempA = headA;
        ListNode tempB = headB;
        //So many edge cases take care
        //What if ele first is colliding and both are size 1, then it will check both ele.next == null return null
        //Also had to take care whenever we move A to B or vice versa its counted as it has been moved to next

        while (tempA != tempB) {
            //Movint to next as already checked for first in while condition
            tempA = tempA.next;
            tempB = tempB.next;

            //Condition to break loop, we could also write tempA == tempB and return tempA, if its collision case we will return
            //ans otherwise if both are null it will return null
            if (tempA == null && tempB == null) {
                return null;
            }

            if (tempA == null)
                tempA = headB;

            if (tempB == null)
                tempB = headA;

        }


        //Case where the first ele is colliding so we neevr go into loop either A B  can be returned
        return tempA;
    }
}
