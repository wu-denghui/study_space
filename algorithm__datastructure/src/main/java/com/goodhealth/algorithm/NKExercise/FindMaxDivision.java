/**
 * 
 */
package com.goodhealth.algorithm.NKExercise;

/**
 * @author 24663
 * @date 2018年8月6日
 * @Description
 */
public class FindMaxDivision {

//	请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。
//	给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
//	测试样例：
//	[9,3,1,10],4
//	返回：6
//	思路：因为要控制复杂度为O（n），所以用排序是不满足题意的。我的思路是，先求出数组中的最大与最小数，
//	之后建立一个最大减最小这个范围大小的数组，再往数组中填充数字。再计算这个数组中连续为0的最大间隔。
//	例如：A={9,3,1,10},求出最大值为10，最小值为1，即可建立一个10 - 1 + 1 = 10 这么大的数组temp[10],
//	因为A[]数组中的数的范围都在1~10之间，那我们可以在temp[0]=1,temp[2]=1,temp[8]=1,temp[9]=1，即
//	{1,0,1,0,0,0,0,0,1,1}，这最大差值即为temp[2]到temp[8]的距离6，返回6;
	public int findMaxDivision(int[] A,int n){
		 int max=A[0];
	        int min=A[0];
	        for (int i=0;i<A.length;++i){
	            if(max<A[i]){
	                max=A[i];
	            }
	            if (min>A[i]){
	                min=A[i];
	            }     
	        }
	        int[] arr=new int[max-min+1];
	        for (int i=0;i<A.length;++i){
	            arr[A[i]-min]++;
	        }
	        int count=0;
	        int result=0;
	        for (int i=0;i<arr.length;++i){
	            if (arr[i]==0){
	                count++;
	            }else {
	                if (result<count){
	                    result=count;
	                }
	                count=0;
	            }
	        }
	        return result+1;
	}
	
}
