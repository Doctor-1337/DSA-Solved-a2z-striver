package topic.array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        //
        //I had the right idea, what I was doing was not iterating the whole wall,
        //We needed to iterate the whole wall and handle the corner elements differently  not in loop condition
        //First we needed to decrease the boundaries as we go, so the subsequent loop will not print those boundary corners
        //Sometimes what will happen is boundary condition changes or all elements have been printed in some of the 4 loops and
        //Rest need not run thats why  added check  for total elements in all loops
        int topBoundary = 0;
        int lowerBoundary = matrix.length - 1;
        int leftBoundary = 0;
        int rightBoundary = matrix[0].length - 1;

        int totalEle = matrix.length * matrix[0].length;

        int currEle = 0;
        List<Integer> ansList = new ArrayList<>();
        while (currEle < totalEle) {

            //Top Wall, i = leftBoundary, j = topBoundary
            for (int i = leftBoundary, j = topBoundary; i <= rightBoundary && currEle < totalEle; i++) {
                ansList.add(matrix[j][i]);
                currEle++;
            }
            topBoundary++;
            //Right Wall, i = topBoundary, j = rightBoundary
            for (int i = topBoundary, j = rightBoundary; i <= lowerBoundary && currEle < totalEle; i++) {
                ansList.add(matrix[i][j]);
                currEle++;
            }
            rightBoundary--;
            //Bottom Wall, i = rightBoundary , j = lowerBoundary
            for (int i = rightBoundary, j = lowerBoundary; i >= leftBoundary && currEle < totalEle; i--) {
                ansList.add(matrix[j][i]);
                currEle++;
            }
            lowerBoundary--;
            //Left Wall, i = lowerBoundary, j = leftBoundary
            for (int i = lowerBoundary, j = leftBoundary; i >= topBoundary && currEle < totalEle; i--) {
                ansList.add(matrix[i][j]);
                currEle++;
            }
            leftBoundary++;
            // leftBoundary++;
            // topBoundary++;
            // rightBoundary--;
            // lowerBoundary--;
        }
        return ansList;
    }
}
