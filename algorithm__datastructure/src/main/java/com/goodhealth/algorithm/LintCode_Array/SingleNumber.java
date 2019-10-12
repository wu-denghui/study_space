package com.goodhealth.algorithm.LintCode_Array;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;


/**
 * @author 24663
 * @date 2018年10月7日
 * @Description
 */
public class SingleNumber {
	public static void main(String[] args) {
		SingleNumber sg=new SingleNumber();
		int[] A={8,3,3,2,2,4,4,5,5,};
		System.out.println(sg.getSingleNumber(A));
	}
	
    /**
     * @param A
     * @return
     * @Description  给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现2次，找到这个数字。
样例
给出 [1,2,3,3,2,4,1] ，返回 4
     */
    public int singleNumber(int[] A) {
        if(A==null||A.length==0){
            return -1;
        }
        int n=A[0];
        for (int i=1;i<A.length ;i++ ) {
            n=n^A[i];
        }
        return n;
    }
    /**
     * @param A
     * @return
     * @Description   给出3*n + 1 个的数字，除其中一个数字之外其他每个数字均出现三次，找到这个数字。
样例
给出 [1,1,2,3,3,3,2,2,4,1] ，返回 4  
     */
/*   三进制异或解法
 *  public int singleNumberII(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result=0;
        int[] bits=new int[32];
        for (int i = 0; i < 32; i++) {
            for(int j = 0; j < A.length; j++) {
                bits[i] += A[j] >> i & 1;
                bits[i] %= 3;
            }

            result |= (bits[i] << i);
        }
        return result;
    }*/
    public int singleNumberII(int[] A) {
        if(A==null||A.length==0){
            return -1;
        }
        HashMap<Integer, Integer>  map=new HashMap<>();
        for (int i=0;i<A.length ;i++ ) {
        	if (!map.containsKey(A[i])) {
				map.put(A[i], 1);
			}else{
				map.put(A[i], map.get(A[i])+1);
			}
        }
        Collection<Entry<Integer, Integer>> collection=map.entrySet();
        for (Entry<Integer, Integer> entry : collection) {
			if (entry.getValue()==1) {
				return   entry.getKey(); 
			}
		}
		return 0;
    }
    
    
    /**
     * @param nums
     * @return
     * @Description 给定数组，除了一个数出现一次外，所有数都出现两次，并且所有出现两次的数都挨着。请找出找出那个出现一次的数。
样例
给出 nums = [3,3,2,2,4,5,5], 返回 4。
     */
    public int getSingleNumber(int[] nums) {
    	if (nums[0]!=nums[1]) {
			return nums[0];
		}
    	for (int i = 1; i +1< nums.length; i++) {
			if (nums[i-1]!=nums[i]&&nums[i]!=nums[i+1]) {
				return nums[i];
			}
		}
    	return nums[nums.length-1];
    }
}
