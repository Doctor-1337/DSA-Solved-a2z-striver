package topic.linkedlist.medium.doubly;

import java.util.ArrayList;

public class FindPairWithGivenSum {
    //Normal two sum with DLL

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        Node tempFront = head;
        Node tempEnd = head;
        if (head == null)
            return null;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (tempEnd.next != null) {
            tempEnd = tempEnd.next;
        }

        while (tempEnd.data > tempFront.data) {
            int sum = tempEnd.data + tempFront.data;

            if (sum == target) {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(tempFront.data);
                ans.add(tempEnd.data);
                list.add(ans);
                tempEnd = tempEnd.prev;
                tempFront = tempFront.next;
            } else if (sum > target) {
                tempEnd = tempEnd.prev;
            } else {
                tempFront = tempFront.next;
            }
        }
        return list;
    }

}
