package com.qg.fangrui.medium.code047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations II
 * @author FunriLy
 * Created by FunriLy on 2018/1/17.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    对于上一题的改造失败，主要是上一题是对原数组进行交换修改，导致原数组的顺序变化不定
    现在换用 九章算法 的解法，新增一个数组用来存储当前组合
    参考资料 https://www.jiuzhang.com/solution/permutations-ii/
     */


    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        if(nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        for ( int i = 0; i < visited.length; i++){
            visited[i] = 0;
        }

        helper(results, list, visited, nums);
        return results;
    }


    private static void helper(List<List<Integer>> results,
                       ArrayList<Integer> list, int[] visited, int[] nums) {

        if(list.size() == nums.length) {
            results.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if ( visited[i] == 1 || ( i != 0 && nums[i] == nums[i - 1]
                    && visited[i-1] == 0)){
                continue;
            }

            /*
            上面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            不应该让后面的2使用。
            */
            
            visited[i] = 1;
            list.add(nums[i]);
            helper(results, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,0,-1,1,0,1};
        List<List<Integer>> result = permuteUnique(nums);

        for(List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
