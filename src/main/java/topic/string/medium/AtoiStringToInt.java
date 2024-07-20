package topic.string.medium;

public class AtoiStringToInt {

    //https://leetcode.com/problems/string-to-integer-atoi/

    //I did long method , doing every check in seperate loop till I reach the actual numbers, segregated the leading spaces, zeroes, and +/- signs

    //Optimal is just reducing the leading spaces, then iterating over a single loop from the point after leading spaces.
    //In  current loop make condition if char current is outside 0-9 range then we stop and return
    //Only 1 special case we need to handle if its not between 0-9, then check if its '+' or '-' and also if they are at the start of our number
    //Otherwise return

    public int myAtoiOptimum(String s) {
        //Empty String check
        if (s.length() == 0)
            return 0;
        int charIdx = 0;
        //Removing leading spaces
        while (charIdx < s.length() && s.charAt(charIdx) == ' ')
            charIdx++;
        boolean isPosi = true;
        long result = 0l;
        int pow = 10;
        //Iterating for answer
        for (int idx = 0; charIdx < s.length(); charIdx++) {

            char ch = s.charAt(charIdx);
            //Check if its +/- symbol and making sure only allowing them at the start
            if ((ch == '+' || ch == '-') && idx == 0) {

                if (ch == '-')
                    isPosi = false;
                idx++;

            } else if (ch >= '0' && ch <= '9') {
                idx++;
                result *= pow;
                result += (ch - '0');
                if (result > Integer.MAX_VALUE) {
                    return isPosi ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }

        }
        return isPosi ? (int) result : -(int) result;
    }

    public int myAtoiLongMethod(String s) {
        int startIdx = 0;
        int result = 0;
        //Skipping leading spaces
        while (startIdx < s.length() && s.charAt(startIdx) == ' ') {
            startIdx++;
        }
        if (startIdx >= s.length())
            return result;
        char startingChar = s.charAt(startIdx);
        boolean isPositive = true;

        if (startingChar == '-') {
            isPositive = false;
            startIdx++;
        } else if (startingChar == '+') {
            startIdx++;
        }
        //Check if no Integer is present
        if (startIdx >= s.length())
            return result;
        startingChar = s.charAt(startIdx);
        while (startIdx < s.length() && s.charAt(startIdx) == '0') {
            startIdx++;
        }
        if (startIdx >= s.length())
            return result;
        startingChar = s.charAt(startIdx);
        if (startingChar < '1' || startingChar > '9')
            return result;
        int unitPlace = 1;
        //Ignoring leading 0's and '-' or '+' sign
        while (startIdx < s.length() && (s.charAt(startIdx) >= '0' && s.charAt(startIdx) <= '9')) {
            startingChar = s.charAt(startIdx++);
            System.out.println(startingChar + " " + result);
            if ((long) ((long) unitPlace * result) > Integer.MAX_VALUE || (long) (result * unitPlace + (long) (startingChar - '0')) > Integer.MAX_VALUE) {
                return isPositive ? Integer.MAX_VALUE : -Integer.MAX_VALUE - 1;
            }
            result *= unitPlace;
            result += (startingChar - '0');
            unitPlace = 10;
        }
        return isPositive ? result : -result;

    }
}
