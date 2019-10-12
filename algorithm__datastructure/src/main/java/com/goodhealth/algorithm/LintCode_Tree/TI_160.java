/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

/**
 * @author 24663
 * @date 2018年9月3日
 * @Description
 * 159. 寻找旋转排序数组中的最小值 
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。 
 * 你需要找到其中最小的元素。 你可以假设数组中存在重复的元素。
 *  样例 给出[4,5,5,6,7,7,0,1,2]
 *  返回 0
 */
public class TI_160 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                end--;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}
