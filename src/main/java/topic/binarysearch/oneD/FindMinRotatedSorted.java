package topic.binarysearch.oneD;

//we have two parts 1 sorted 1 not, if left is sorted get the min as nums[lo], move lo = mid+1. vice versa right sorted array
//get nums[mid] as lowest and move hi = mid-1
public class FindMinRotatedSorted {

    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;


        // if(nums[lo] < nums[hi] || nums.length == 1)
        //     return nums[lo];
        int low = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + hi >>> 1;

            // if( nums[mid] == nums[hi] && nums[hi] == nums[lo]){

            //     lo++;
            //     hi--;
            //     continue;
            // }
            // if(nums[mid] > nums[mid+1]){
            //     return nums[mid+1];
            // }
            if (nums[mid] >= nums[lo]) {
                low = Math.min(low, nums[lo]);
                lo = mid + 1;
                //  if(nums[mid] > target && nums[lo] <= target){
                //    // while(lo<mid && nums[mid] == nums[mid-1])mid--;
                //     hi = mid-1;
                // }else{
                //   //  while(mid<hi && nums[mid] == nums[mid+1])mid++;

                // }
                // }else if(nums[mid] < target && nums[hi] >= target){
                //   //  while(mid<hi && nums[mid] == nums[mid+1])mid++;
                //     lo = mid+1;
            } else {
                //  while(lo<mid && nums[mid] == nums[mid-1])mid--;
                hi = mid - 1;
                low = Math.min(low, nums[mid]);
            }
        }
        return low;
    }

}
