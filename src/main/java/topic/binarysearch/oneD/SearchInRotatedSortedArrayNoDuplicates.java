package topic.binarysearch.oneD;

public class SearchInRotatedSortedArrayNoDuplicates {

    //    https://leetcode.com/problems/search-in-rotated-sorted-array/
    //Make sure we are doing partioning
    //First identify if we are in left sorted array or right sorted array
    //get inside which partition we are then start reducing space
    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + hi >>> 1;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[lo]) {
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < target && nums[hi] >= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;


    }
}
