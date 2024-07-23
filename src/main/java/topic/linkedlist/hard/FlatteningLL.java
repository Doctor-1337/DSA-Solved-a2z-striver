package topic.linkedlist.hard;

public class FlatteningLL {


    class Node {
        public int data;
        public Node next;
        public Node child;

        Node() {
            this.data = 0;
            this.next = null;
            this.child = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }

        Node(int data, Node next, Node child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }
    }

    public static Node flattenLinkedList(Node head) {

        if (head == null) {
            return head;
        }

        Node one = head;
        Node two = flattenLinkedList(head.next);

        Node newHead = null;

        Node prevOne = null;
        Node prevTwo = null;
        Node temp = null;

        while (one != null && two != null) {
            if (one.data < two.data) {
                if (temp == null) {
                    temp = one;
                    newHead = temp;
                } else {
                    temp.next = one;
                    temp = temp.next;
                }
                one = one.child;
                temp.next = null;
            } else {
                if (temp == null) {
                    temp = two;
                    newHead = temp;
                } else {
                    temp.next = two;
                    temp = temp.next;

                }
                two = two.child;
                temp.next = null;
            }
        }

        while (one != null) {
            if (temp == null) {
                temp = one;
                newHead = temp;
            } else {
                temp.next = one;
                temp = temp.next;
            }
            // temp.next = one;
            // temp = temp.next;
            one = one.child;
        }
        while (two != null) {
            if (temp == null) {
                temp = two;
                newHead = temp;
            } else {
                temp.next = two;
                temp = temp.next;
            }
            // temp.next = two;
            // temp = temp.next;
            two = two.child;
        }

        return newHead;

    }

}
