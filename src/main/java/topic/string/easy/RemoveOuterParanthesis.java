package topic.string.easy;

public class RemoveOuterParanthesis {

    //   https://leetcode.com/problems/remove-outermost-parentheses/
    public String removeOuterParentheses(String s) {
        //Counter which will increment on open bracker and decrement on closing bracket.
        //It will always be greater than 1 for open bracket which is nested, so part of answer
        //And It will always be greater than 0 for closing bracket which is nested, so part of answer
        int currlvl = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                currlvl++;
                if (currlvl > 1)
                    sb.append(ch);
            } else if (ch == ')') {
                currlvl--;
                if (currlvl > 0)
                    sb.append(ch);

            }


        }
        return sb.toString();
    }
}
