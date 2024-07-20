package topic.string.medium;

import java.util.HashMap;
import java.util.Map;

public class SubStrikngWithAtmostKDistinchCharacters {
//    Its the sme as longestSubWithKdistinch instead of that ans we just need to calc i-j whenever length <=k
//Suppose we have abcd, it will have abcd, bcd, cd, d so endIdx - start idx is our count for the currWindow

    long substrCount(String S, int K) {

        int hi = 0;
        int lo = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        int maxLen = 0;

        while (hi >= lo && hi < S.length()) {

            freqMap.put(S.charAt(hi), freqMap.getOrDefault(S.charAt(hi), 0) + 1);

            if (K == freqMap.size()) {
                //maxLen = Math.max(maxLen,hi - lo + 1);
                maxLen += 1;
            } else if (freqMap.size() > K) {
                while (freqMap.size() > K) {
                    if (freqMap.get(S.charAt(lo)) > 1) {
                        freqMap.put(S.charAt(lo), freqMap.get(S.charAt(lo)) - 1);
                    } else {
                        freqMap.remove(S.charAt(lo));
                    }
                    lo++;
                }
                //maxLen = Math.max(maxLen,hi - lo + 1);
                maxLen += 1;
            }
            hi++;
        }
        return maxLen;
    }

}
