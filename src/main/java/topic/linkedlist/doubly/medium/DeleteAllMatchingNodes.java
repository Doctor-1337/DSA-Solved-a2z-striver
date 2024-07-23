package topic.linkedlist.medium.doubly;

public class DeleteAllMatchingNodes {

    //Take care of starting and end values their prev and next will be null
    //Take care of moving head if currHead == target
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            if (temp.data == x) {
                Node prev = temp.prev;
                Node next = temp.next;
                if (next != null) {
                    next.prev = prev;
                }
                if (prev != null) {
                    prev.next = next;
                } else {
                    head = temp.next;
                }
                // prev = temp;

                // prev.next = null
                // prev.prev = null;

            }
            temp = temp.next;
        }
        return head;


    }
}
