package topic.string.easy;

public class LargestOddNoInString {

    //https://leetcode.com/problems/largest-odd-number-in-string/

    //Only trick is always start from the right that is end of string
    //If the end place is odd then we have found the largest odd number from that no till start

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int curr = num.charAt(i) - '0';

            if (curr % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
