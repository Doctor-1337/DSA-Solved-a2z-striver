package topic.binarysearch.twoD;

public class SearchInRowColWiseSortedMatrix {
    //https://leetcode.com/problems/search-a-2d-matrix-ii/
    //We go criss cross diagonally from right top or left bottom diagonal,
    //We cannot go from the tother two ends as for binary search we need 1 area reducing 1 increasing
    //1 area greater 1 area lower to reduce our search space that will only happen in 2 of the 4 corners.
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }


        }
        return false;
    }
}
