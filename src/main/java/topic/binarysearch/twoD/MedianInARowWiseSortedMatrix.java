package topic.binarysearch.twoD;

public class MedianInARowWiseSortedMatrix {
    //https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
    int median(int matrix[][], int R, int C) {
        // code here

        //Brute force is just taking all in a array, sorting and finding mid
        //optimise is we need median means, we need element at 1 greater than half (floor val)
        //n*m/2 + 1th value is what we need
        //Now Intuition is we find the number who has n*m/2 + 1 values lower than it or equal to it in matrix
        //we do binary search across the range of numbers in matrix present
        //then  check how many number are lesser or equal to that  number and if its equal to n*m/2 + 1 its our answer
        // to find how many numbers are smaller we simpy do upperBound check at every row for our current potential ans
        //Upper bound is binary search, iterating over every row is linear
        int hi = 0;
        int lo = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[0].length - 1] > hi)
                hi = matrix[i][matrix[0].length - 1];

            if (matrix[i][0] < lo)
                lo = matrix[i][0];


        }

        int target = (R * C) / 2;
        while (hi >= lo) {
            int mid = hi + lo >>> 1;

            int upperBound = findUpperBound(matrix, mid);

            if (upperBound <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private int findUpperBound(int matrix[][], int target) {
        int totalUpperBound = 0;
        for (int i = 0; i < matrix.length; i++) {
            int lo = 0;
            int hi = matrix[0].length - 1;
            while (hi >= lo) {
                int mid = hi + lo >>> 1;

                if (matrix[i][mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            totalUpperBound += lo;
        }
        return totalUpperBound;
    }

}
