package topic.binarysearch.oneD;

public class FirstAndLastEleInArray {

    //Edge case handle when ele is not present or lo goes out of bound or just use a variable to store occurence initialise it with -1;
    public int[] searchRange(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + hi >>> 1;

            if (arr[mid] >= x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        int[] ans = new int[]{-1, -1};
        if (lo >= arr.length || lo < 0 || arr[lo] != x)
            return ans;
        ans[0] = lo;
        lo = 0;
        hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + hi >>> 1;

            if (arr[mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        ans[1] = hi;
        return ans;
    }
}
