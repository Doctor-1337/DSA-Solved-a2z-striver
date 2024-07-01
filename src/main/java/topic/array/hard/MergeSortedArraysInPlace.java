package topic.array.hard;

import java.util.Arrays;

public class MergeSortedArraysInPlace {

    //Was getting TLE, Appoach was correct take smaller from the two arrays, swap the sort both back
    //But optimise it arr1 needs the smallest n numbers. we check the smalles of arr2 and largest of arr1
    //if arr2 < arr1 , we swap smallest of arr2 and largest of arr1
    //This way we have 1 of the elements that needs to be in arr1
    //Repeat this until we fill arr1 completely or deplete arr2 or arr1 < arr2 means further nothing is needed as
    //Other elements are already sorted
    //Function to merge the arrays.
    public static void mergeInPlaceNonOptimum(long arr1[], long arr2[], int n, int m) {
        int i = 0;
        int j = m - 1;
        while (i < n) {
            if (arr1[i] > arr2[0]) {
                long temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                i++;
                if (arr2.length > 1 && arr2[0] > arr2[1]) {
                    Arrays.sort(arr2);
                }
            } else {
                i++;
            }
        }
    }

    //Was getting TLE, Appoach was correct take smaller from the two arrays, swap the sort both back
    //But optimise it arr1 needs the smallest n numbers. we check the smalles of arr2 and largest of arr1
    //if arr2 < arr1 , we swap smallest of arr2 and largest of arr1
    //This way we have 1 of the elements that needs to be in arr1
    //Repeat this until we fill arr1 completely or deplete arr2 or arr1 < arr2 means further nothing is needed as
    //Other elements are already sorted
    //Function to merge the arrays.
    public static void mergeOptimised(long arr1[], long arr2[], int n, int m) {
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < m) {
            if (arr1[i] > arr2[j]) {
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;

            } else {
                break;
            }
        }
        Arrays.sort(arr2);
        Arrays.sort(arr1);


    }
}
