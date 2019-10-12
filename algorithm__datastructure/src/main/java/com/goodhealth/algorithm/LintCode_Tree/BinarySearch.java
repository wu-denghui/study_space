/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Tree;


/**
 * @author 24663
 * @date 2018年9月3日
 * @Description
 */
public class BinarySearch {
	
     public int BSearch(int[] an ,int target){
    	 int left=0;
    	 int right=an.length-1;
    	 int mid=0;
    	 while (left+1<right) {
    		 mid=left+(right-left)/2;
    		 if (an[mid]==target) {
				right=mid;
			}else if(an[mid]>target){
				right=mid;
			}else{
				left=mid;
			}
		}
    	 if (an[left]==target) {
			return left;
		}
    	 if (an[right]==target) {
			return right;
		}
    	 return -1; 
     }
}
