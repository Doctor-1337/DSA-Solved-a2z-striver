package topic.string.easy;

public class ValidAnagram {

//    https://leetcode.com/problems/valid-anagram/description/

    //Just take a char array, count frequency,

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] arr = new int[26];

        int n = s.length();
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            arr[idx] = arr[idx] + 1;
        }

        for (int i = 0; i < n; i++) {
            int idx = t.charAt(i) - 'a';
            if (arr[idx] == 0) {
                return false;
            } else {
                arr[idx] = arr[idx] - 1;
            }
        }
        return true;
    }
}
