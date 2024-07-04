package topic.array.hard;

public class ProductSubArray {

    //https://leetcode.com/problems/maximum-product-subarray/

    //Go with intuition approach think of kadane but notice how it will take so many variables
    //There can be 3 conditions
    //0 negatives, even negative, odd negative
    //Every odd negative can be turned into even negative giving anm overall positive result by not considering one of the negatives
    //We either leave the first negative or the last negative and at every pioint check if array prodyuct is greater than max
    //we take 2 max 1 from behing so we get sum includint the last negative and the other from start to do vice versa.
    //In total there are 4 regions which will all be covered in these 2 variables
    public int maxProduct(int[] nums) {
        //Edge case when having max = 0;, whjat if array has {-2};
        //it will never consider -2 as its lower than max so keep max = Integer.MIN_VALUE;
        //Edge case 2 using int or long was giving overflow so used double but Min value of double is
        //Double Min value is Double.NEGATIVE_INFINITY not Double.MIN_VALUE
        int n = nums.length;
        double max = Double.NEGATIVE_INFINITY;
        double prefix = 1.0;
        double suffix = 1.0;
        for (int i = 0; i < n; i++) {

            if (prefix == 0) prefix = 1l;
            if (suffix == 0) suffix = 1l;

            prefix *= nums[i];
            suffix *= nums[n - i - 1];

            max = Math.max(max, Math.max(prefix, suffix));
        }
        return (int) max;
    }
}
