package topic.binarysearch.twoD;

public class FindPeakInMAtrix {

    //https://leetcode.com/problems/find-a-peak-element-ii

    //Brute is going through matrix and finding the max element among all
    //Optimised is ofc binary search because we need to optimise search space
    ///Its peak element think abouit how to use peak element for 1 D array
    // We use binary search to select a random col, then find max in that column
    //If curr ele is i.e mat[row][maxCol] is peak (it is bigger than left and right, ts alreadyt bigger then top and bottom ele as its max of that col)
    //Now we use reducing space by moving where the curve is , i.e if left is greater that means peak will be at left, if right is greater peak will be right
    //Refer to peakIndex que  you will get where to move
    //This works becuase iwe have to max in column and we move to the next max in other  column, that means that new max col either should be greatest
    //OR it will help us move to even greater

    public int[] findPeakGrid(int[][] mat) {
        int lo = 0;
        int hi = mat[0].length - 1;

        while (lo <= hi) {
            int mid = hi + lo >>> 1;

            int maxRowELe = findMaxInRow(mat, mid);

            int left = mid > 0 ? mat[maxRowELe][mid - 1] : -1;
            int right = mid < (mat[0].length - 1) ? mat[maxRowELe][mid + 1] : -1;
            int midNo = mat[maxRowELe][mid];
            if (midNo > left && midNo > right) {
                return new int[]{maxRowELe, mid};
            } else if (midNo < left) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int findMaxInRow(int[][] mat, int col) {
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > mat[max][col]) {
                max = i;
            }

        }
        return max;
    }

}
