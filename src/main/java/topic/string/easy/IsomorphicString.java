package topic.string.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {

//    https://leetcode.com/problems/isomorphic-strings/submissions/1321152213/

    //Edge cases are when duplicates, and when some value in t is already mapped, we cannot map it again
    //SO we kind of need to match the key value pairs as well as take care if value is already matched do not map it to other key
    //Eg b a d c , b a b a : here b is mapped to b but we also try to map d with b , that is wrong
    //So we kind of need to have a map or set to check for other string t as key as well
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();
        Set<Character> uniqueChar = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);

            if (charMap.containsKey(char1) && (char) charMap.get(char1) != char2) {
                return false;
            } else if (!charMap.containsKey(char1) && uniqueChar.contains(char2)) {
                return false;
            }
            charMap.put(char1, char2);
            uniqueChar.add(char2);


        }
        return true;
    }
}
