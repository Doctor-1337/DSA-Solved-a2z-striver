package topic.array.medium;

public class RotateMatrixby90 {

    //https://leetcode.com/problems/rotate-image/
    //Brute force create another matrix and fill with formula derived from observation
    // rotated[j][n - i - 1] = matrix[i][j];
    public void rotate(int[][] matrix) {
        int currCol = matrix[0].length - 1;
        int currRow = matrix.length - 1;

        //Transpose col becomes row, row becomes col i.e matrix[row][col] = matrix[col][row]
        //We only  do for 1 half of matrix seperated by diagonal because if done for both it will back to original
        // i will go from 0 to n-2 (from first row till second last row, draw diagram and see why because last row i.e n-1)
        // n-1 th row will be on diagonal and we are not shifting diagonal
        //j will be from i+1 to n-1 (see diagram j first ele is diagonal so we always need to move 1 ahead of i to be seperated by diagonal)
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swap(i, j, matrix);
            }
        }


        int lo = 0;
        int hi = matrix[0].length - 1;

        while (hi > lo) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][hi];
                matrix[i][hi] = matrix[i][lo];
                matrix[i][lo] = temp;
            }
            hi--;
            lo++;

        }
    }

    private void swap(int ptr1, int ptr2, int[][] nums) {
        int temp = nums[ptr1][ptr2];
        nums[ptr1][ptr2] = nums[ptr2][ptr1];
        nums[ptr2][ptr1] = temp;
    }

}
