package topic.binarysearch.twoD;

public class FindTargetInMatrixSortedRowWIse {
    // matrix is sorted row wise as well as the 1st element of next row is always greater than last of element of previous row

    //https://leetcode.com/problems/search-a-2d-matrix/description/
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int hi = n - 1;
        int lo = 0;

        if (matrix[0][0] > target)
            return false;

        //Either we can find upper bound -> Ceiling then we will have check that in col = 0
        //Or we can find lower bound -> floor, then we will have to check in col = m-1;
        //This way we will get our potential row where ans can be
        //Check now in row with binary search
        while (hi >= lo) {
            int mid = hi + lo >>> 1;

            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        int rowTarget = lo - 1;
        if (matrix[rowTarget][m - 1] < target)
            return false;

        hi = m - 1;
        lo = 0;
        while (hi >= lo) {
            int mid = hi + lo >>> 1;

            if (matrix[rowTarget][mid] == target) {
                return true;
            } else if (matrix[rowTarget][mid] > target) {

                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
