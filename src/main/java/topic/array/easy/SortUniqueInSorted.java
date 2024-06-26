package topic.array.easy;

public class SortUniqueInSorted {
//    https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
    //Find it tough, but figured out a way, use 2 pointers, 1 pointer just ahead of all unique, other pointer iterating array
    //keep check if currEle is unique if unique swap increase unique pointer
    // dont need the lastUnique as it will be nums[uIdx-1] (left of uniqueIdx);
    public int removeDuplicates(int[] nums) {
        int lastUnique = nums[0];
        int uIdx = 1;
        for(int i=1;i<nums.length;i++){
            if(lastUnique != nums[i]){
                lastUnique = nums[i];
                if(i != uIdx){
                    int temp = nums[i];
                    nums[i] = nums[uIdx];
                    nums[uIdx] = temp;
                }
                uIdx++;
            }
        }
        return uIdx;
    }
}
