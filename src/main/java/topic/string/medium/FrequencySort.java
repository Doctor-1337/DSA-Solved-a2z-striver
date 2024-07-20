package topic.string.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

//    https://leetcode.com/problems/sort-characters-by-frequency/description/

    //Used so many variables for keeping track of index
    //Better would've been just using '0' as the index for all
    //Like for digits idx of 1 would be = '1' - '0' = 1
    //For smallCase 'a' idx = 'a' - '0' = 'a' - '0' = 49
    //FOr uppercase 'A' idx = 'A' - 0 =     'A' - '0' = 17
    //it will have a total of 49 + 'z' - 'a' indexes
    //There will be wasteful idx in between but this is helping us avoid the If else checks


    //We could use priority que as well that will lead to optimisatioin where we do not have to find max, as polling will give always max
    //Where i got stuck is, priorityque is not map so needed another map to cound the frequency of all chars
    //Then when we counted frequences then we store it in our priority queue, as we could not do same in priority by calling it
    //to fetch currChar and update its frequency this lookup doesnt happen in 0 (1) here, so we need map to get the final frequencies
    //After filling queue, we just need to iterate till its empty and append as many of the chars till its freq is zero
    //Learning is how to use comparator and priority que add poll methods
    public String frequencySortIfElse(String s) {

        final int SMALL_CASE_START_IDX = 0;
        final int SMALL_CASE_END_IDX = SMALL_CASE_START_IDX + 'z' - 'a';
        final int UPPER_CASE_START_IDX = SMALL_CASE_END_IDX + 1;
        final int UPPER_CASE_END_IDX = UPPER_CASE_START_IDX + 'Z' - 'A';
        final int DIGIT_START_IDX = UPPER_CASE_END_IDX + 1;
        final int DIGIT_END_IDX = DIGIT_START_IDX + '9' - '0';

        int[] charArr = new int[62];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';
                charArr[idx]++;
            } else if (ch >= '0' && ch <= '9') {
                int idx = ch - '0' + DIGIT_START_IDX;
                charArr[idx]++;
            } else {
                int idx = ch - 'A' + UPPER_CASE_START_IDX;
                charArr[idx]++;
            }
        }
        StringBuilder sb = new StringBuilder();

        int stringLen = 0;
        while (stringLen < s.length()) {
            int max = 0;
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[max] < charArr[i])
                    max = i;
            }
            int ascii = -1;
            if (max >= SMALL_CASE_START_IDX && max <= SMALL_CASE_END_IDX) {
                ascii = max + 'a';
            } else if (max >= UPPER_CASE_START_IDX && max <= UPPER_CASE_END_IDX) {
                ascii = max + 'A' - UPPER_CASE_START_IDX;
            } else {
                ascii = max + '0' - DIGIT_START_IDX;
            }
            char charToAppend = (char) ascii;
            while (charArr[max] > 0) {
                sb.append((charToAppend));
                stringLen++;
                charArr[max]--;
            }
        }
        return sb.toString();
    }

    public String frequencySortNoIfElse(String s) {
        int[] arr = new int[122];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - '0'] = arr[ch - '0'] + 1;
        }
        int max = 0;
        int idx = -1;
        StringBuilder sb = new StringBuilder();
        while (sb.length() != s.length()) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= max) {
                    idx = i;
                    max = arr[i];
                }
            }
            for (int i = 0; i < max; i++)
                sb.append((char) (idx + '0'));
            arr[idx] = 0;
            max = 0;

        }
        return sb.toString();
    }

    //PriorityQueue solution
    public static class Pair {
        char character;
        int frequency;

        public Pair(char ch, int fre) {
            character = ch;
            frequency = fre;
        }
    }

    public String frequencySort(String s) {
        PriorityQueue<Pair> que = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.frequency, p1.frequency));

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            que.add(new Pair(entry.getKey(), entry.getValue()));
        }

        StringBuilder result = new StringBuilder();
        while (!que.isEmpty()) {
            Pair p = que.poll();
            for (int i = 0; i < p.frequency; i++) {
                result.append(p.character);
            }
        }

        return result.toString();

    }
}
