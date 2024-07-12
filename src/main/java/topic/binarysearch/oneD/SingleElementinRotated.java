package topic.binarysearch.oneD;

public class SingleElementinRotated {
    //https://leetcode.com/problems/single-element-in-a-sorted-array/
    public int singleNonDuplicate(int[] nums) {

        int hi = nums.length - 1;
        int lo = 0;

        if (nums.length == 1)
            return nums[0];
        //Checking so that we can ignore corner cases and dont have to keep handle mid-1 mid+1 cases overflowing
        if (nums[0] != nums[1])
            return nums[0];

        if (nums[hi] != nums[hi - 1])
            return nums[hi];

        while (hi >= lo) {
            int mid = hi + lo >>> 1;
            //Odd Even rule, in the lef half pairs will be odd even, in the right half even odd. SO check if in left half or righht half
            //if in left half cancel that. if in right half cancel that
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];

            if ((mid % 2 == 1 && nums[mid + 1] == nums[mid]) || (mid % 2 == 0 && nums[mid - 1] == nums[mid])) {
                hi = mid - 1;

            } else {
                lo = mid + 1;
            }
        }
        return -1;

    }
}
