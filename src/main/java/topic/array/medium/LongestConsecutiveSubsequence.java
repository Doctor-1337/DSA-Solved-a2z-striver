package topic.array.medium;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        // https://leetcode.com/problems/longest-consecutive-sequence/description/
        //Basic is just that we are trying to find for each no how many consecutives it contains
        //For eg we have nums[i] = 100, now we find out all the consecutives lesser and greater than 100
        //Then print the maxLen
        //Now we optimise this buy first using hashSet to quickly lookup if the said element is there while
        //Trying to calculate the consecutive Array for an Element.
        //We further optimise by, suppose we have in array 100 99 98 97 96 95, we shouldnt check for 100 99 98 97 96
        //We can optimise this by going to 95 then printing all the greater consecutives
        //so basically find the lowest of all possible consecutive sub sequences and count their len
        //print highst len
        //We only count the len when we are at the lowest ele of our potential sub sequences i.e !Set.contains(nums[i]-1)

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int currNum = nums[i] + 1;
                int currLen = 1;
                while (set.contains(currNum)) {
                    currNum++;
                    currLen++;
                }

                maxLen = Math.max(currLen, maxLen);
            }
        }
        return maxLen;
    }
}
