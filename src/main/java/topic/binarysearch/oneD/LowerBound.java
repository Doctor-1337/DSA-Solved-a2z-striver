package topic.binarysearch.oneD;

public class LowerBound {

    //Remember how we pass through our answer by doing lo = mid-1; and then returning hi;

    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x) {
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + hi >>> 1;

            if (arr[mid] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;

    }
}
