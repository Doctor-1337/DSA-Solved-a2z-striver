package topic.array.medium;

public class SetMatrixZeroes {
    //    https://leetcode.com/problems/set-matrix-zeroes/
    //Remember use some array to store if curr row will be zero
    //current col will be zero
    //for Better soln we use serpate row col arrays
    //for optimal we do in firstRow firstCOl and a variable to avoid ovverlap at matrix[0][0]
    //Space M + N
    public void setZeroesBetter(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] rowArr = new boolean[rows];
        boolean[] colArr = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowArr[i] = true;
                    colArr[j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowArr[i] == true || colArr[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }

    }


    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean colZero = false;

        //Like the better solution instead of using other arrays for storing if row is zero/ col is zero
        //We use  row first as all the columns that needs to be zero
        //We use first col to handle all rows that needs to be zero
        //But there is an edge case if we take row and col for storing Zeros we will have matrix[0][0]
        //Holding for both row and col, if we do for col it will happen for row
        //if we do for row it will happen for col
        //so To avoid we take variable colZero to check columneZero is zero or not
        //When matrix[i][j] == 0 and j == 0 we will set colZero as true instead of
        //matrix[i][j] == 0 as it might go to matrix[0][0] for i = 0 and alter our rows result
        //Now while setting the zeroes we first set zeroes of inner matrix leaving our row and col Zero holding
        //i.e leave i = 0, j = 0 start from i = 1 , j = 1 set according to matrix[0][j], matrix[i][0]
        //Now time to set for first row and first col
        //Remember if we first go with hanndling the first col then matrix[0][0] may become 0
        //Which will lead to setting the first row zero i.e first row is dependent on matrix[0][0]
        //As for our first col our result depends on a seperate variable we can alter the first row
        //Even if matrix[0][0] now becomes 0 we do not care about it as for setting the first column
        //We will check if colZero is true or not
        //Edge case I though everytime matrix[0][0] when colZero is true but I was wrong suppose
        //Row 0th doesnt have any zerooes but column oth have zeroes in that case it was failing
        //E.g [[1,2,3,4],[0,1,2,3],[1,2,3,4]] here matrix[1][0] is Zero therefore colZero = true
        //But row 0th is not zero as all elements of zero row are non zero
        //Therefore we need to handle it while setting our columne First from colZero
        //I was just going from i=1 while setting ColumnFirst assuming it will be zero when colZero is true

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    if (j == 0) {
                        colZero = true;
                    } else {
                        matrix[0][j] = 0;
                    }

                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 1; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
