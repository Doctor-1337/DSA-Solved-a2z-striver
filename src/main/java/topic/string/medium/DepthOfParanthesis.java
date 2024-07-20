package topic.string.medium;

public class DepthOfParanthesis {


//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
    //Very easy if you know the concept of using a counter to increment when ) and decrement when (
    //Keep track of curr counterVal and max value, and update when curCount > maxCounter;

    public int maxDepth(String s) {
        int max = 0;
        int curr = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')') {
                curr--;
            } else if (ch == '(') {
                curr++;
            }

            max = Math.max(max, curr);
        }
        return max;
    }

}
