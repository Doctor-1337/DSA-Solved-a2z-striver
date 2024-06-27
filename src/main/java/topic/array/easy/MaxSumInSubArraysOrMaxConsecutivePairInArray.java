package topic.array.easy;

public class MaxSumInSubArraysOrMaxConsecutivePairInArray {
//https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0
    //Question was found after doing kadane's Also, it had sub array so got confused
    // Gist is 2 lowest val elements with the max sum will always be a pair of consecutive elements, so just need to check
    // array for the pair of consecutive elements which gives largest sum
    //Proof suppose we have [1,2,3,4,5]  we take 1,2 gives 3 now we want to increase array size
    // Two case either Next num is bigger or smaller, if num smaller our Sum will reduce as new smaller is found.
    // If num  bigger it will be ignored as curr Both values are the smallest in array so only need those two
    //In this way its useless to increase array size only need sub array of size 2 ans max of 2 consecutive ele's

    public static long pairWithMaxSum(long arr[], long N) {
        if (N < 2)
            return -1;

        long maxSum = arr[0] + arr[1];

        for (int i = 2; i < N; i++) {

            maxSum = Math.max(maxSum, arr[i] + arr[i - 1]);
        }
        return maxSum;
    }

}
