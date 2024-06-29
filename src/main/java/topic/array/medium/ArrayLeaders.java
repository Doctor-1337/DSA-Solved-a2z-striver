package topic.array.medium;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    //Just had to make sure to iterate from end, its the trick then keep a track of currMax if nums[i] is greater or equal than currMax then its a leader.

    static ArrayList<Integer> leaders(int n, int arr[]) {
        // Your code here
        int currMax = arr[n - 1];
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= currMax) {
                ansList.add(arr[i]);
                currMax = arr[i];
            }
        }
        Collections.reverse(ansList);
        return ansList;
    }
}
