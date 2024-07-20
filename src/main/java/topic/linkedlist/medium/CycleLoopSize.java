package topic.linkedlist.medium;

public class CycleLoopSize {

    //brute force is just using hashmap to find the start element where it collides i.e fastP = slowP,
    //Map store idx of that collide element when first encountered , eg Map.put(currNode,5th idx);
    //Map.find(currNode) at 15th idx again means it has repeated, now 15 - 5 = 10 loop size


    //Optimised approach is doing tortoise hare, then when collided, make 1 pointer stay and move other pointer by 1, keep counter and increment till the
    //moving pointer reached back to stationary pointer
    static int countNodesinLoop(ListNode head) {
        ListNode slowP = head;
        ListNode fastP = head;
        int counter = 0;
        //Tortoise Hare
        //If loop present theyu will collide somewhere
        //When collided, take slowP  to head,
        //Then increment both by 1 again, till they meet, this is our starrting piont
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;

            if (slowP == fastP) {
                counter++;
                slowP = slowP.next;
                while (slowP != fastP) {
                    counter++;
                    slowP = slowP.next;
                }
                return counter;
            }
        }
        return counter;
    }

}
