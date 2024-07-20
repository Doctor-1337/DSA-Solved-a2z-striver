package topic.string.medium;

public class RomanToInt {

    //Easy question just need to remember the concept of going from right to left, and starting from length-2 instead of length -1\
    //Length-1 is our starting sum and starting lastChar to avoid using check for overflow and underflow
    //Keeping 2 variables, currChar, and lastChar, if lastChar was greater than currChar its sum -= currChar, else sum += currChar
    //Its the law of we have a preceeding small value it needs to be deducted otherwise incremented
    //Also instead of hashmap for storing the values of ROman, use array to store the values
    public int romanToInt(String s) {
        int[] arr = new int[26];
        arr['I' - 'A'] = 1;
        arr['V' - 'A'] = 5;
        arr['X' - 'A'] = 10;
        arr['L' - 'A'] = 50;
        arr['C' - 'A'] = 100;
        arr['D' - 'A'] = 500;
        arr['M' - 'A'] = 1000;

        int sum = 0;
        int lastCharVal = arr[s.charAt(s.length() - 1) - 'A'];
        sum = lastCharVal;
        for (int i = s.length() - 2; i >= 0; i--) {
            int currCharVal = arr[s.charAt(i) - 'A'];
            if (currCharVal < lastCharVal) {
                sum -= currCharVal;
            } else {
                sum += currCharVal;
            }
            lastCharVal = currCharVal;
        }
        return sum;
    }

}
