/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;

/**
 * @author 24663
 * @date 2018年9月3日
 * @Description
 * 
 * 74. 第一个错误的代码版本
代码库的版本号是从 1 到 n 的整数。某一天，有人提交了错误版本的代码，因此造成自身及之后版本的代码在单元测试中均出错。
请找出第一个错误的版本号。
你可以通过 isBadVersion 的接口来判断版本号 version 是否在单元测试中出错，具体接口详情和调用方法请见代码的注释部分。
样例
给出 n=5
调用isBadVersion(3)，得到false
调用isBadVersion(5)，得到true
调用isBadVersion(4)，得到true
此时我们可以断定4是第一个错误的版本号
挑战
调用 isBadVersion 的次数越少越好
 */
public class TI_74 {
	
    public int findFirstBadVersion(int n) {
    	int left=1;
    	int right=n;
    	if (n<1) {
    		return -1;
    	}else{
    		while (left+1<right) {
    	    int mid=left+(right-left)/2;
				if (isBadVersion(mid)) {
					right=mid;
				}else{
					left=mid+1;
				}
			}
    		if (isBadVersion(left)) {
				return left;
			}
    	}
    	return right;
    }

	/**
	 * @param mid
	 * @return
	 * @Description 
	 */
	private boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

}
