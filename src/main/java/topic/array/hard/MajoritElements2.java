package topic.array.hard;

import java.util.ArrayList;
import java.util.List;

public class MajoritElements2 {
    //https://leetcode.com/problems/majority-element-ii/
    public List<Integer> majorityElement(int[] nums) {

        //Its just same as doing majority element, just count how many max solutions here can be
        //when we divide something by 3  it will be 33% 33% 33% means 3 elements will have same proportions
        //So majority ele's have to be lessser than 3 that is 2 at most. Appearing more than n/2 means more than 33%
        //for 2 majority elements they can be 34% each remaining will be 31 that cant be majoirt as its lesser than 33%
        //means we can have atmost 2 majority n/3 ele
        //No we need to just repeat same algo as done for n/2 but taking into account for 2
        //Edge case suppose we have 1 as ele1 but somehow we end up with 1 in ele2 as well
        //this will break as both ele1 == ele2 == 1, so we put check nums[i] != ele2 for counting ele1 and vice versa
        //1 more edge case I was init ele1 == ele2 as 0 it was breaking for [0,0,0] as In this case ive already breached the
        //condition saiod above so we start with Integer.Min_value which doesnt occur in array and wont hamper our result.
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (cnt1 == 0 && nums[i] != ele2) {
                cnt1 = 1;
                ele1 = nums[i];
            } else if (cnt2 == 0 && nums[i] != ele1) {
                cnt2 = 1;
                ele2 = nums[i];
            } else if (nums[i] == ele1) {
                cnt1++;
            } else if (nums[i] == ele2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }

        }
        cnt1 = 0;
        cnt2 = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1) {
                cnt1++;
            }
            if (nums[i] == ele2) {
                cnt2++;
            }
        }

        if (cnt1 > nums.length / 3)
            ans.add(ele1);
        if (cnt2 > nums.length / 3)
            ans.add(ele2);
        return ans;
    }
}
