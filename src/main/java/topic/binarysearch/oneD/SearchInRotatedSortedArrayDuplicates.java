package topic.binarysearch.oneD;

//Same as non dupicates just have to make sure of condition where arr[hi] == arr[mid] == arr[lo]
//Do lo ++ , hi -- until above condiitons is resolved
//Eg [101111]
public class SearchInRotatedSortedArrayDuplicates {
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

    public boolean search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + hi >>> 1;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] >= nums[lo]) {

                if (nums[mid] > target && nums[lo] <= target) {
                    while (lo < mid && nums[mid] == nums[mid - 1]) mid--;
                    hi = mid - 1;
                } else {
                    while (mid < hi && nums[mid] == nums[mid + 1]) mid++;
                    lo = mid + 1;
                }
            } else if (nums[mid] < target && nums[hi] >= target) {
                while (mid < hi && nums[mid] == nums[mid + 1]) mid++;
                lo = mid + 1;
            } else {
                while (lo < mid && nums[mid] == nums[mid - 1]) mid--;
                hi = mid - 1;
            }
        }
        return false;
    }

}
