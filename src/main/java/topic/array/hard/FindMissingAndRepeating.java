package topic.array.hard;

public class FindMissingAndRepeating {

    //Just need to memorise the math
    //Sum of nums = sum, sum of square of nums = sumSq
    //sum - realSum = x- y; x = repeating ele, y missing ele; realSum = n*(n+1)/2
    //sumSq - realSumSq = (x+y)(x-y) [x^2 - y^2], realSumSq = n*(n+1)*(2*n+1))/6
    //Edge case make sure we have long to hold sum and diff
    //COde wasnt compiling because I wrote n*(n+1)*(2n+1))/6 instead of n*(n+1)*(2*n+1))/6  (notice 2n vs 2*n)
    //Edge case N was also needed to be converted from int to n
    //If you dont know the formulas of sum ans sumSq just use i and i*i;
    //Edge case when iterating oveflow
    //notice how handled in the code vs see commented out code
    // int[] findTwoElement(int arr[], int n) {
    //     long N = (long)n;
    //     long sum = arr[0];
    //     long sumSq = arr[0]*arr[0];

    //     for(int i=1;i<n;i++){
    //         sum+=(long)arr[i];
    //         sumSq += ((long)arr[i]*(long)arr[i]);
    //     }

    //     long sumReal = (N*(N+1))/2;
    //     long sumSqReal = (N*(N+1)*((2*N)+1))/6;

    //     long sumDiff = (sum - sumReal);
    //     long sumSqDiff = (sumSq - sumSqReal);

    //     long xPlusY = sumSqDiff/sumDiff;
    //     long x = (sumDiff + xPlusY)/2;
    //     long y = (xPlusY-x);
    //     return new int[]{(int)x,(int)y};

    // }

    int[] findTwoElement(int arr[], int n) {

        long prod = 1;
        long prodN = 1;
        long sum = 0;
        long sumN = 0;

        for (int i = 1; i <= n; i++) {

            sum += (long) arr[i - 1];
            prod += (long) arr[i - 1] * arr[i - 1];
            prodN += (long) i * i;
            sumN += (long) i;
        }

        long const1 = sum - sumN;
        long const2 = (prod - prodN) / const1;
        long x = (const1 + const2) / 2;
        long y = x - const1;
        int arr2[] = new int[2];
        arr2[0] = (int) x;
        arr2[1] = (int) y;
        return arr2;

    }
}
