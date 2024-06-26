package topic.array.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {


    //Always remember what is in the hasmap and what do we need to check
    //Maths is currSum - prevHashMapSum = K
    //prevHashMapSum = currSum - K (this is what we check in  hashmap)
    public static int lenOfLongSubarr(int nums[], int N, int k) {
        //Complete the function

        Map<Integer, Integer> sumIdxMap = new HashMap<>();
        // sumSoFar, SumAtIdx, sumReq, now Suppose at a point sum is 20, and earlier at somepoint it was 13, now
        // sumReq = 7, if we don currsum - sumEarlier = 7 (sumReq), therefore sumEarlier = sum - k
        //We save sumEarlier in hashmap and at every iteratiopn keep checking if we have such a sum
        //when deducted gives us ans;
        //Logic  currsum - sumEarlier =  (sumReq),
        //now we need to find   sumEarlier = sum - k in our hashmap


        // suppose at anytime we get complete sum = k , then we need to add 0 to it to form pair
        //Eg at idx 2 we get sum 15 = k, now x + 15 = k, x = 0; we need 0 in hashmap thats why saving otherwise will
        // have to handle with certain if condition if Currsum == k  (x == 0) ;
        sumIdxMap.put(0, -1);

        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int currSum = sum + nums[i];
            int prevSum = currSum - k;
            //Now check if x is there in hashmap or not
            if (sumIdxMap.containsKey(prevSum)) {
                int curSubArrLen = i - sumIdxMap.get(prevSum);
                if (curSubArrLen > max)
                    max = curSubArrLen;
            }
            //handle negative, if we want longest we do not update the past val (currSum) as it will give longer
            //For eg we have 10 in hashmap, then we add 10 give us 20 in hashmap now suppose we get -10 the it
            //will make sum again 10 but we already have 10 in map as we want longest we will not update
            //just in case we are doing count then we need to handle accordingly and add count of currSum
            if (!sumIdxMap.containsKey(currSum)) {
                sumIdxMap.put(currSum, i);
            }
            sum = currSum;
        }

        return max;
    }
}
