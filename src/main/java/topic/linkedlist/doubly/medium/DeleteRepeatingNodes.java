package topic.linkedlist.medium.doubly;

public class DeleteRepeatingNodes {
    //Same as Delete all matching nodes just need to make sure to keep updating target as the last unique node.data
    Node removeDuplicates(Node head) {
        // Code Here.
        // Write your code here
        if (head == null || head.next == null)
            return head;
        int x = head.data;
        Node temp = head.next;
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
                }
                // prev = temp;

                // prev.next = null
                // prev.prev = null;

            } else {
                x = temp.data;
            }
            temp = temp.next;
        }
        return head;
    }

}
