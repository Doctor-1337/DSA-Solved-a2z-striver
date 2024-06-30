package topic.array.hard;

import java.util.*;

public class Q3Sum {

//    https://leetcode.com/problems/3sum/

    // ALways remember brute force is using as many loops as the num of elements in an answer set
    //Better solution is reduce 1 loop and use hashing
    //Optimised is using pointers after sorting the array uses no space. but same complexity as better.

    public List<List<Integer>> threeSumHashing(int[] nums) {
        //Hashing approach works by reducing another nested loop
        //so if we need triplets we can use hashing and get n^3 to n^2;
        //Run 2 loops, take two pointers keep storing the val of faster pointer in hashmap
        //In every iteration check if map contains -(nums[i] (slower/outer loop) + nums[j] (faster/inner loop))
        //If true it is our triplet
        //keep adding result in a set after sorting to remove duplicates

        int hi = nums.length - 1;

        Set<List<Integer>> ansSet = new HashSet<>();
        //Arrays.sort(nums);
        //Set<Integer> map= new HashSet<>();
        for (int i = 0; i < hi - 1; i++) {
            // int k = hi;
            Set<Integer> map = new HashSet<>();
            for (int j = i + 1; j <= hi; j++) {
                int currSum = (nums[i] + nums[j]) * -1;
                if (map.contains(currSum)) {
                    List<Integer> ansList = new ArrayList<>();
                    ansList.add(nums[i]);
                    ansList.add(nums[j]);
                    ansList.add(currSum);
                    Collections.sort(ansList);
                    ansSet.add(ansList);
                }
                map.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(ansSet);
        return ans;
    }

    //Using three pointers -> as many ele required in set
    //We sort the array so if we move the pointer ahead it will increase the ttoalSUm, if we move back it will reduce
    //fix 3 pointers i =0;j=i+1; k at nums.length-1; now iterate over i and j, take total sum of 3.
    //if sum > 0 means sum is more then do k-- (reducing total sum)
    //if sum < 0 means sum is lower then do j++ (increasing total sum)
    //if sum == 0 , oput in set make sure not duplicate and do k--, j++ to not fill with dupllicates
    //Edge case what if after sum == 0, and k--, j++ its still the same nums it will increase time complexity
    //take to loops that does k-- and j++ until new values of both are found
    public List<List<Integer>> threeSumPointers(int[] nums) {
        int hi = nums.length - 1;

        Set<List<Integer>> ansSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < hi - 1; i++) {
            int k = hi;
            for (int j = i + 1; j < k; ) {
                int currSum = nums[i] + nums[j] + nums[k];
                if (currSum == 0) {
                    ansSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j <= i && nums[j] == nums[j - 1]) j++;
                    while (k >= j && nums[k] == nums[k + 1]) k--;
                } else if (currSum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(ansSet);
        return ans;
    }
}
