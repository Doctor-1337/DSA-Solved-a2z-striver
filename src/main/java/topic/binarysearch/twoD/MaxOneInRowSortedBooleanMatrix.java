package topic.binarysearch.twoD;

public class MaxOneInRowSortedBooleanMatrix {
    //    https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1?
    //Binary Search n long m
    int rowWithMax1sBetter(int arr[][], int n, int m) {
        // code here
        int maxOne = 0;
        int maxRow = -1;

        for (int i = 0; i < n; i++) {


            int lo = 0;
            int hi = arr[i].length - 1;

            while (hi >= lo) {
                int mid = hi + lo >>> 1;

                if (arr[i][mid] == 1) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            if (lo < arr[i].length) {
                int currOne = arr[i].length - lo;
                if (currOne > maxOne) {
                    maxOne = currOne;
                    maxRow = i;
                }

            }
        }
        return maxRow;
    }

    //Optimised O n + m -> it uses stair way.  We find the first occurence of 1 in row = 0; then move to next row
    //then keep updating till we reacher a greater row

    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int maxOne = 0;
        int maxRow = -1;

        int j = m - 1;
        for (int i = 0; i < n; i++) {


            while (j >= 0 && arr[i][j] == 1) {
                j--;
                maxRow = i;
            }


        }

        return maxRow;
    }
}
