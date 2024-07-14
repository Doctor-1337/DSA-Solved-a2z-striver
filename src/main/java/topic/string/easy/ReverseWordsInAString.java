package topic.string.easy;

public class ReverseWordsInAString {

    //https://leetcode.com/problems/reverse-words-in-a-string/

    //Major intuition is just doing it in place
    //First reverse whole array, this way words at back are at front
    //No re reverse the string word wise so the reversed words with changed order of occurence becomes normal
    //We have our stirng from backwards now
    //There were edge cases to handle spaces, remember to ignore spaces at front and back by moving through them with pointers.
    //Reversal is by  two pointer method

    public String reverseWords(String s) {
        int hi = s.length() - 1;
        int lo = 0;
        char[] arr = s.toCharArray();
        while (hi > lo) {
            char temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            hi--;
            lo++;
        }
        // return new String(arr);
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                size++;
            } else {
                hi = i - 1;
                lo = i - size;

                while (lo < hi) {
                    char temp = arr[lo];
                    arr[lo] = arr[hi];
                    arr[hi] = temp;
                    hi--;
                    lo++;
                }
                size = 0;
            }
        }

        if (size > 0) {
            hi = arr.length - 1;
            lo = arr.length - size;

            while (lo < hi) {
                char temp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = temp;
                hi--;
                lo++;
            }
            size = 0;
        }
        StringBuilder sb = new StringBuilder();
        boolean isSpaceRepeated = true;

        lo = 0;
        hi = arr.length - 1;

        while (hi > lo && (arr[hi] == ' ' || arr[hi] == ' ')) {
            if (arr[hi] == ' ')
                hi--;
            if (arr[lo] == ' ')
                lo++;
        }
        System.out.println(hi + " " + lo);
        for (int i = lo; i <= hi; i++) {
            if (arr[i] != ' ') {
                sb.append(arr[i]);
                isSpaceRepeated = false;
            } else if (!isSpaceRepeated) {
                sb.append(arr[i]);
                isSpaceRepeated = true;
            }
        }
        return new String(sb);
    }
}
