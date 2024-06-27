package topic.array.medium;

import java.util.ArrayList;

public class ReArrangeElementsBySign {


    //Had problem in this because , didnt think we can do it without space.
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int negPtr = 1;
        int posPtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[posPtr] = nums[i];
                posPtr += 2;
            } else {
                ans[negPtr] = nums[i];
                negPtr += 2;
            }
        }
        return ans;
    }

    //this is the brute force approach/ with 2 itertation - O 2N, it will be also used in follow up question i.e when numOfPos != numOfNeg
    public int[] rearrangeArrayBruteAndVariation(int[] nums) {
        int[] ans = new int[nums.length];
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                ans[2 * i] = pos.get(i);
                ans[2 * i + 1] = neg.get(i);
            }

            for (int i = neg.size() * 2, j = neg.size(); i < ans.length; i++, j++) {
                ans[i] = pos.get(j);
            }
        } else if (pos.size() < neg.size()) {
            for (int i = 0; i < pos.size(); i++) {
                ans[2 * i] = pos.get(i);
                ans[2 * i + 1] = neg.get(i);
            }

            for (int i = pos.size() * 2, j = pos.size(); i < ans.length; i++, j++) {
                ans[i] = neg.get(j);
            }
        }
        return ans;
    }


}
