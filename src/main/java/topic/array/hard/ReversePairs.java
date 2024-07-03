package topic.array.hard;

import java.util.ArrayList;
import java.util.List;

//Based on divide and conquer
//Works different then count inversion because in that we only need to find the number of pairs that would correct the array, so we find the pair correct tthe array and
//Dont consider it for further
//here In count inversion we are trying to find the smaller number suppose we are at 6 and 3, we see 3 is smaller, we add 3 to our answer list, and increment the right pointer to compare next pointer with 6, missing out on comparing 3 with the next elements in left array. (this is how I understood).
//Merge sort then logic while merging is the trick.
public class ReversePairs {

    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);


    }

    private int mergeSort(int[] nums, int lo, int hi) {
        int cnt = 0;
        if (lo >= hi)
            return cnt;

        int mid = (lo + hi) / 2;
        cnt += mergeSort(nums, lo, mid);
        cnt += mergeSort(nums, mid + 1, hi);
        cnt += merge(nums, lo, mid, hi);
        return cnt;
    }

    private int merge(int[] nums, int lo, int mid, int hi) {
        int rPtr = mid + 1;
        int lPtr = lo;
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = lPtr; i <= mid; i++) {
            while (rPtr <= hi && (long) nums[i] > 2l * nums[rPtr]) {
                rPtr++;
            }
            cnt += (rPtr - (mid + 1));
        }
        rPtr = mid + 1;
        while (lPtr <= mid && rPtr <= hi) {
            if (nums[lPtr] < nums[rPtr]) {
                ans.add(nums[lPtr++]);
            } else {
                ans.add(nums[rPtr++]);
            }
        }

        while (lPtr <= mid) {

            ans.add(nums[lPtr++]);

        }

        while (rPtr <= hi) {

            ans.add(nums[rPtr++]);

        }

        for (int i = lo; i <= hi; i++) {
            nums[i] = ans.get(i - lo);
        }
        return cnt;
    }

}
