package topic.array.medium;

public class Sort012s {

    //Brute - sorting array with in built fun
    // better - counting no of 0s 1s 2s then filling the array
    // optimised just  3 pointer solution using Dutch National Flag Algorithm, single iteration O of N no space.


    //Was problematic
    //RRemember how you did the easy question  sort 0s 1s, its same just swapping but it has 3 eles
    //so what we do is take 3 pointers, 3 region, start to low 0s, lo to iterator 1s,iterator to highs uncertain/unsorted region, and hig end 2s
    //now we draw the conditions when iterator == 0, move to 0s region, iterator == 1 move to 1st region, iterator 2s = move to 2s region
    //I got edge case where we needed to do while(hi >= iterator) we need to do it because its the uncertain region , single ele here doesnt know if its sorted so perform for this as well
    // while(hi > lo) will not work
    //BBasically what we do is keep 4 regions 3 sorted 1 unsorted, we iterate unsorted region and keep placing at the inserting index of unsorted region

    //https://leetcode.com/problems/sort-colors/
    public void sortColors(int[] nums) {
        int lo = 0;
        int mid = 0;
        int hi = nums.length - 1;

        while (mid <= hi) {
            if (nums[mid] == 0) {
                swap(nums, mid, lo);
                mid++;
                lo++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, hi, mid);
                hi--;
            }
        }
    }

    private void swap(int[] nums, int pt1, int pt2) {
        int temp = nums[pt1];
        nums[pt1] = nums[pt2];
        nums[pt2] = temp;
    }
}
