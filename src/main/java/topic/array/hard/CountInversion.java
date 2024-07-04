package topic.array.hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversion {
    //https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
    //Just do merge sort
    //While merging remember the algo of counting  if nums[lPtr] > nums[rPtr] ; cnt += lPtr-lo + 1;
    static long inversionCount(long arr[], int n) {
        // Your Code Here

        return CountInversion.mergeSort(arr, 0, n - 1);


    }

    static long mergeSort(long[] arr, int lo, int hi) {
        long cnt = 0l;
        if (hi <= lo) return cnt;
        int mid = (lo + hi) / 2;

        cnt += mergeSort(arr, lo, mid);
        cnt += mergeSort(arr, mid + 1, hi);
        cnt += merge(arr, lo, mid, hi);
        return cnt;
    }

    static long merge(long arr[], int lo, int mid, int hi) {
        List<Long> ans = new ArrayList<>();
        int leftP = lo;
        int rightP = mid + 1;
        long cnt = 0l;
        while (leftP <= mid && rightP <= hi) {
            if (arr[leftP] > arr[rightP]) {
                cnt += mid - leftP + 1;
                ans.add(arr[rightP]);
                rightP++;
            } else {
                ans.add(arr[leftP]);
                leftP++;
            }
        }

        while (rightP <= hi) {
            ans.add(arr[rightP]);
            rightP++;
        }
        while (leftP <= hi) {
            ans.add(arr[leftP]);
            leftP++;
        }
        int num = 0;
        // while(num < ans.size()){
        //     arr[lo+num] = ans.get(num);
        //     num++;
        // }
        for (int i = lo; i <= hi; i++) {
            arr[i] = ans.get(i - lo);
        }
        return cnt;
    }
}
