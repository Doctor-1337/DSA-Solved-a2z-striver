package topic.array.medium;

public class NextPermutation {

    //https://leetcode.com/problems/next-permutation/
    //Had trouble with this question
    //Revision needed
    //Breaking Idx   concept
    //Take example [1 2 3 4 5] ,   [5 4 3 2 1] ->> 1 is increasing 1 is decreasing as
    //As we move in dictionary order our array becomes from increasing to decreasing
    // [1 2 3 4 5] -> [1 2 3 5 4] -> [1 2 5 3 4] -> [1 5 2 3 4] -> [5 1 2 3 4] -> [5 1 2 3 4]
    //Notice how at every iteration the decreasing array is increasing and the increasing array is decreasing in size.
    //BreakingIdx is the idx, where increasing array  ends and decreasing array starts from the next pointer
    //We do this as for next greater permutation we need to create a greater ele, but array some part is in descending order
    //means we need an ele smaller that we can place in our decreasing array and create a greater permutation by  swapping the higher
    // next greater integer with the breakIdx value which increases the posirtion of greater element , increases the size of decreasing array
    // Take it like this that decreasing array cannot be increased further with its elements so we need an element from increasing array to increase the
    // no of places in decreasing array (eg. 6 places to now 7 places which will always be greater than 6 places)
    //Now we just need to use these 7 places and create a no that is still large by replacing our increasing ele with the next greater element from decvreasing array
    //what this does is the position of a greater num is given to the element at breakingIdx creating a 7 digit no with greater value
//https://www.youtube.com/watch?v=JDOXKqF60RQ
    public void nextPermutation(int[] nums) {
        // Step 1 : Find breakIdx -> remember always from last so to go in order
        int breakingIdx = -1;
        //Finding the next smaller element from the last that we can use to create next permutation

        //Remember if we do from start it will give error because we find a next greater permutation but
        //it COuld be a much greater next permutation and not the next, thats why start from end always
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                breakingIdx = i - 1;
                break;
            }
        }
        //Check if Array is already max permutation, then just rev as it will give the 1st permutation
        if (breakingIdx == -1) {
            rev(0, nums.length - 1, nums);
            return;
        }

        //Step 2 : Swap the breakingIdx Ele with the next greater ele from the decreasing array.
        for (int i = nums.length - 1; i > breakingIdx; i--) {
            if (nums[i] > nums[breakingIdx]) {
                swap(i, breakingIdx, nums);
                break;
            }
        }
        //Making the decreasing array into increasing array so greater elements are at least bits (llike creating the smallest num with our curr numbers)
        rev(breakingIdx + 1, nums.length - 1, nums);
    }

    private void rev(int lo, int hi, int[] nums) {
        while (lo < hi) {
            swap(lo, hi, nums);
            lo++;
            hi--;

        }
    }

    private void swap(int ptr1, int ptr2, int[] nums) {
        int temp = nums[ptr1];
        nums[ptr1] = nums[ptr2];
        nums[ptr2] = temp;
    }


}
