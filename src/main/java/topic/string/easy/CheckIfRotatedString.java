package topic.string.easy;

public class CheckIfRotatedString {

    // I Used contains method, better would've been doing the logic on my own.

// Take the string with string+string = abc is the string we will make abcabc ,  now we check bca.

// Iterate over the double String. At every char till toMatch string's length, do substring and match with toMatch string.

    //Basically doing s = s+s , we dont have to do modulus to handle overflow,Now we can just check if s contains goal.

    public boolean rotateStringWithContains(String s, String goal) {
        String dummy = s + s;

        if (dummy.contains(goal) && s.length() == goal.length())
            return true;
        return false;
    }


    public boolean rotateStringWithoutContains(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        s += s;
        for (int i = 0; i < goal.length(); i++) {

            if (matches(s.substring(i, i + goal.length()), goal))
                return true;

        }
        return false;
    }

    private static boolean matches(String s, String goal) {

        for (int i = 0; i < goal.length(); i++) {

            if (goal.charAt(i) != s.charAt(i))
                return false;

        }
        return true;

    }

}
