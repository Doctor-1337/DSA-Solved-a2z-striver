package topic.array.easy;

public class SecondLargest {

//    https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/
    // Problem -> making sure of edge cases
    // Edge cases, -> When 1st ele is the largest, When All are equal, When no 2nd largest if present make sure to return -1

    public int secondLargestInSortedArray(int arr[], int n){
        int max = arr[0];
        int maxT = Integer.MIN_VALUE;
        boolean isP = false;
        for(int i=1;i<n;i++){
            if(arr[i] > max){
                maxT = max;
                max =arr[i];
                isP = true;
            }else if(arr[i] > maxT && arr[i] != max){
                maxT = arr[i];
                isP = true;
            }
        }
        return isP ? maxT : -1;
    }


}
