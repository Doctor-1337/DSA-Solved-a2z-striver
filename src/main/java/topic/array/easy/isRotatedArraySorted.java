package topic.array.easy;

public class isRotatedArraySorted {
    //https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
    // Check if more than 1 peak is there then not sorted,
    // Edge case -> do wrap around means, last element also needs to be compared with first ele
    public boolean check(int[] nums) {

        boolean isPeakReached = false;

        for(int i=0;i<nums.length;i++){
            if(nums[i] > nums[(i+1)%nums.length]){

                if(isPeakReached){
                    return false;
                }else{
                    isPeakReached = true;
                }
            }
        }
        return true;
    }
}
