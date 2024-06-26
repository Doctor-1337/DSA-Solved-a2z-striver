package topic.array.medium;

public class SortUniqueInSorted2 {
    //    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
    //When did the easy one this felt really easy (ref : SortUniqueInSorted, https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
    // Just had to add another condition to consider unique, when curr Unique ele is only appeared once,  consider it one more time as unique
    public int removeDuplicates2(int[] nums) {
        int lastUnique = nums[0];
        int uIdx = 1;
        int currUniCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (lastUnique != nums[i]) {
                lastUnique = nums[i];
                if (i != uIdx) {
                    int temp = nums[i];
                    nums[i] = nums[uIdx];
                    nums[uIdx] = temp;
                }
                currUniCount = 1;
                uIdx++;
            } else if (currUniCount < 2) {
                lastUnique = nums[i];
                if (i != uIdx) {
                    int temp = nums[i];
                    nums[i] = nums[uIdx];
                    nums[uIdx] = temp;
                }
                currUniCount++;
                uIdx++;
            }
        }
        return uIdx;
    }
}
