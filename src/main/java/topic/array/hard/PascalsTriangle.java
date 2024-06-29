package topic.array.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    //    https://leetcode.com/problems/pascals-triangle/
    public List<List<Integer>> generate(int numRows) {
        //Ez que just need to generate accoringly
        //Observation start and end has 0
        //Other elements are sum of prevList prevIdx and currIdx
        //Was failing i = 0; j=0; i < numRows but j <= i, i will be less.  j will be less and Equal (i was doing j < i)
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ans.add(1);
                } else {
                    List<Integer> prevAns = ansList.get(i - 1);
                    ans.add(prevAns.get(j) + prevAns.get(j - 1));
                }
            }
            ansList.add(ans);
        }
        return ansList;
    }
}
