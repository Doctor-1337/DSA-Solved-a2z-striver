package topic.array.hard;

import java.util.*;

public class Q4Sum {

    // https://leetcode.com/problems/4sum/
    //same as 2/3 pointer make sure integer overflow while calculating sum by using long

    public List<List<Integer>> fourSumHashing(int[] nums, int target) {
        //Hashing approach works by reducing another nested loop
        //so if we need triplets we can use hashing and get n^3 to n^2;
        //Run 2 loops, take two pointers keep storing the val of faster pointer in hashmap
        //In every iteration check if map contains -(nums[i] (slower/outer loop) + nums[j] (faster/inner loop))
        //If true it is our triplet
        //keep adding result in a set after sorting to remove duplicates

        //Edge case getting values of totalSum very huge so do incremental and use Long data type
        //For eg we need 3 varialbles sum
        //Store like 2 variables sum in 1 long
        //then next calc in diff variable
        //or just use 1 variable but with long data type, above 2 variable we be optimised as we dont have to calc nums[i]+nums[j] everytime

        int hi = nums.length - 2;

        Set<List<Integer>> ansSet = new HashSet<>();
        //Arrays.sort(nums);
        //Set<Integer> map= new HashSet<>();
        for (int i = 0; i < hi - 1; i++) {
            // int k = hi;

            for (int j = i + 1; j < hi; j++) {
                Set<Long> map = new HashSet<>();
                for (int k = j + 1; k <= hi + 1; k++) {
                    long currSum = (long) target - nums[i] - nums[j] - nums[k];
                    if (map.contains(currSum)) {
                        List<Integer> ansList = new ArrayList<>();
                        ansList.add(nums[i]);
                        ansList.add(nums[j]);
                        ansList.add(nums[k]);
                        ansList.add((int) currSum);
                        Collections.sort(ansList);
                        ansSet.add(ansList);
                    }
                    map.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(ansSet);
        return ans;
    }

    public List<List<Integer>> fourSumPointers(int[] nums, int target) {
        //Hashing approach works by reducing another nested loop
        //so if we need triplets we can use hashing and get n^3 to n^2;
        //Run 2 loops, take two pointers keep storing the val of faster pointer in hashmap
        //In every iteration check if map contains -(nums[i] (slower/outer loop) + nums[j] (faster/inner loop))
        //If true it is our triplet
        //keep adding result in a set after sorting to remove duplicates

        //Edge case getting values of totalSum very huge so do incremental and use Long data type
        //For eg we need 3 varialbles sum
        //Store like 2 variables sum in 1 long
        //then next calc in diff variable
        //or just use 1 variable but with long data type, above 2 variable we be optimised as we dont have to calc nums[i]+nums[j] everytime

        int hi = nums.length - 2;

        Set<List<Integer>> ansSet = new HashSet<>();
        Arrays.sort(nums);
        //Set<Integer> map= new HashSet<>();
        for (int i = 0; i < hi - 1; i++) {
            // int k = hi;

            for (int j = i + 1; j < hi; j++) {
                Set<Long> map = new HashSet<>();
                int last = hi + 1;
                for (int k = j + 1; k < last; ) {
                    long currSum = (long) nums[last] + nums[i] + nums[j] + nums[k];


                    if (currSum == target) {
                        ansSet.add(Arrays.asList(nums[i], nums[j], nums[k], nums[last]));
                        k++;
                        last--;
                        while (k <= hi && nums[k] == nums[k - 1]) k++;
                        while (last > j && nums[last] == nums[last + 1]) last--;
                    } else if (currSum < target) {
                        k++;
                    } else {
                        last--;
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(ansSet);
        return ans;
    }
}
