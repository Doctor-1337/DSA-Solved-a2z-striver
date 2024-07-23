package topic.linkedlist.hard;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //Optimised method instead of storing new LL we store it into originalNode.next, where originalNode.next becomes originalNode.next.next;

    public Node copyRandomListOptimisedNoSpace(Node head) {
        Node temp = head;
        if (head == null)
            return head;
        while (temp != null) {
            Node replica = new Node(temp.val);
            replica.next = temp.next;
            temp.next = replica;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null) {
            Node replica = temp.next;
            replica.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }
        temp = head;

        Node replica = new Node(-1);
        Node replicaHead = replica;
        while (temp != null) {
            replica.next = temp.next;
            replica = replica.next;
            temp.next = temp.next.next;
            replica.next = null;
            temp = temp.next;
        }
        return replicaHead.next;


    }

    public Node copyRandomListWithSpace(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node replica = new Node(temp.val);
            map.put(temp, replica);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node replica = map.get(temp);
            replica.random = map.get(temp.random);
            replica.next = map.get(temp.next);
            map.put(temp, replica);
            temp = temp.next;
        }
        return map.get(head);


    }
}
