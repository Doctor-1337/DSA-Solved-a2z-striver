package topic.array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    //    https://leetcode.com/problems/merge-intervals/
    //Did onown,
    //Just memorise how to do sorting
    //Remember the concept of start and end pointer
    //Remember to handle the last row out of the loop
    public int[][] merge(int[][] intervals) {
        int[][] merged = new int[intervals.length][intervals[0].length];
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = end > intervals[i][1] ? end : intervals[i][1];

            } else {
                List<Integer> ans = new ArrayList<>();
                ans.add(start);
                ans.add(end);
                ansList.add(ans);
                start = intervals[i][0];
                end = intervals[i][1];

            }
        }
        List<Integer> ans1 = new ArrayList<>();
        ans1.add(start);
        ans1.add(end);
        ansList.add(ans1);
        int[][] ansArr = new int[ansList.size()][2];
        int idxArr = 0;
        for (List<Integer> ans : ansList) {
            ansArr[idxArr][0] = ans.get(0);
            ansArr[idxArr++][1] = ans.get(1);
        }
        return ansArr;
    }
}
