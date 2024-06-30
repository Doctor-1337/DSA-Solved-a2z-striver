package topic.array.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubArrayXor {

    //It was same as sub array sum K but instead of sum it was XOR
    //Just needed to know the condition which will be used to lookup map
    //Suppose x ^ k = XR , take xor both sides of K
    // x = XR ^ k
    //So in hashmap we check if we have a xor val that is equal to XR ^ k.

    //  https://www.naukri.com/code360/problems/count-subarrays-with-given-xor_1115652

    //Where i was wrong 1. Gettting the map comparing condition
    //I was using currXor operator but wasnt upating our totalXorsoFar, we dont need currXor just use xorSoFar and keep updating it check commented code
    public static int subarraysXor(ArrayList<Integer> arr, int k) {
        Map<Integer, Integer> xorMap = new HashMap<>();
        xorMap.put(0, 1);
        int xorSoFar = 0;
        int cnt = 0;
        for (int i = 0; i < arr.size(); i++) {
            int currXor = xorSoFar ^ arr.get(i);

            int x = currXor ^ k;

            if (xorMap.containsKey(x)) {
                cnt += xorMap.get(x);
            }
            //Was missing this step, altho currXor is redundant we can just use xorSoFar.
            xorSoFar = currXor;
            xorMap.put(currXor, xorMap.getOrDefault(currXor, 0) + 1);
        }
        return cnt;

        // int n = a.size(); //size of the given array.
        // int xr = 0;
        // Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        // mpp.put(xr, 1); //setting the value of 0.
        // int cnt = 0;

        // for (int i = 0; i < n; i++) {
        //     // prefix XOR till index i:
        //     xr = xr ^ a.get(i);

        //     //By formula: x = xr^k:
        //     int x = xr ^ k;

        //     // add the occurrence of xr^k
        //     // to the count:
        //     if (mpp.containsKey(x)) {
        //         cnt += mpp.get(x);
        //     }

        //     // Insert the prefix xor till index i
        //     // into the map:
        //     if (mpp.containsKey(xr)) {
        //         mpp.put(xr, mpp.get(xr) + 1);
        //     } else {
        //         mpp.put(xr, 1);
        //     }
        // }
        // return cnt;
    }
}
