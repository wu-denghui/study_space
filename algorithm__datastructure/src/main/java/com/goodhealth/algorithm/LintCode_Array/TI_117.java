/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Array;


/**
 * @author 24663
 * @date 2018年10月6日
 * @Description
 *  * 116. 跳跃游戏
给出一个非负整数数组，你最初定位在数组的第一个位置。　　　
数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　
判断你能到达数组的最后一个位置的步数。
样例
A = [2,3,1,1,4]，返回 2.
 */
public class TI_117 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TI_117 iTi_116=new TI_117();
		int[] A={13,52,42,21,58};
		int[] B={5,8,3,0,6,7,9,6,3,4,5,2,0,6,2,6,7,10,8,0};
		System.out.println(iTi_116.jump1(A));
	}
	
	//使用动态规划
    public int jump(int[] A) {
    	//bool[i]表示从位置0到位置的最小跳跃数
    	int[] bool=new int[A.length];
        bool[0]=0;
        for (int i= 1; i<bool.length ; i++) {
    		int  an=Integer.MAX_VALUE;
    		int un=Integer.MAX_VALUE;
    		//情况一:先跳到i-1，再跳到i；
    		if (i-1>=0&&A[i]>=1) {
    			an=bool[i-1]+1;
    		}
    		for (int j= 0; j <i; j++) {
    			//情况二：检索0到i-1内所有可以跳到i的点j，再从j调到i；
    			if (A[j]>=i-j) {
    				un=Math.min(un,bool[j]+1);
				}
			}
    		//比较两种情况中最小的
    		bool[i]=Math.min(an, un);
		}
		return bool[A.length-1];
    }
    
    
    //使用贪心算法
    public int jump1(int[] A) {
    	//未检索过的元素的开头
    	int start=0;
    	//目前走的最远距离
    	int end=0;
    	//返回值，走了多少步
    	int steps=0;
    	while (end<A.length-1) {
    		steps++;
    		//维护的值far，表示在steps步下能走的最远距离
			int far=end;
			//在第n步能走到范围内寻找第n+1步能走的最大的步子
			for (int i = start; i <= end; i++) {
				if (A[i]+i>far) {
					far=A[i]+i;
				}
			}
			//检索过得元素不在检索
			start=end+1;
			//更新走了多远
			end=far;
		}
		return steps;
    }
}
