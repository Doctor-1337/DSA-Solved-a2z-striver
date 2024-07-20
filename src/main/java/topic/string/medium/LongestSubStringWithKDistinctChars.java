package topic.string.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctChars {

//    https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

    //Two pointers, sliding window.
    //Keep a map to count frequency of chars, where map.size == no Of distinct elements
    //Keep adding elements to map, if map size == k calculte ans
    //if map.size > k, remove elements
    //Use hi pointer for adding elements, and lo pointer to back track the added elements and keep removing them whenever size > K
    public int longestkSubstr(String S, int K) {

        int hi = 0;
        int lo = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        int maxLen = -1;

        while (hi >= lo && hi < S.length()) {

            freqMap.put(S.charAt(hi), freqMap.getOrDefault(S.charAt(hi), 0) + 1);

            if (K == freqMap.size()) {
                maxLen = Math.max(maxLen, hi - lo + 1);
                // maxLen += 1;
            } else if (freqMap.size() > K) {
                while (freqMap.size() > K) {
                    if (freqMap.get(S.charAt(lo)) > 1) {
                        freqMap.put(S.charAt(lo), freqMap.get(S.charAt(lo)) - 1);
                    } else {
                        freqMap.remove(S.charAt(lo));
                    }
                    lo++;
                }
                maxLen = Math.max(maxLen, hi - lo + 1);
                //maxLen += 1;
            }
            hi++;
        }
        return maxLen;
    }


}
