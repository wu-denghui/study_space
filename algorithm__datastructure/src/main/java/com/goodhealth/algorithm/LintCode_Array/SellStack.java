/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Array;

/**
 * @author 24663
 * @date 2018年10月7日
 * @Description
 */
public class SellStack {

	/**
	 * @param args
	 * @Description
	 */
	public static void main(String[] args) {
		SellStack sl = new SellStack();
		int[] prices = { 4, 4, 6, 1, 1, 4, 2, 5 };
		System.out.println(sl.maxProfit(prices));

	}

	/**
	 * @param prices
	 * @return
	 * @Description 149. 买卖股票的最佳时机 假设有一个数组，
	 * 它的第i个元素是一支给定的股票在第i天的价格。
	 * 如果你最多只允许完成一次交易
	 * (例如,一次买卖股票),设计一个算法来找出最大利润。
	 *  样例 给出一个数组样例 [3,2,3,1,2], 返回 1
	 */
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(prices[i], min);     //找到到第i天为止最低价的一天
			profit = Math.max(profit, prices[i] - min);  //当前最大利润为  当前价减去最低价与之前最大利润中的大者
		}
		return profit;
	}



	/**
	 * @param prices
	 * @return
	 * @Description 150. 买卖股票的最佳时机 II 假设有一个数组，
	 * 它的第i个元素是一个给定的股票在第i天的价格。
	 *              设计一个算法来找到最大的利润。你可以完成尽可能多的交易(多次买卖股票)。
	 *              然而,你不能同时参与多个交易(你必须在再次购买前出售股票)。 
	 *              样例 给出一个数组样例[2,1,2,0,1], 返回 2
	 */
	public int maxProfitII(int[] prices) {
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		int profit = 0;
		for (int i = 0; i + 1 < prices.length; i++) {
			if (prices[i] < prices[i + 1]) {
				profit += prices[i + 1] - prices[i];
			}
		}
		return profit;
	}

	/**
	 * @param prices
	 * @return
	 * @Description 151. 买卖股票的最佳时机 III 
	 * 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
	 *              设计一个算法来找到最大的利润。
	 *              你最多可以完成两笔交易。 样例 给出一个样例数组 [4,4,6,1,1,4,2,5],
	 *              返回 6 注意事项 你不可以同时参与多笔交易(你必须在再次购买前出售掉之前的股票)
	 */
	public int maxProfitIII(int[] prices) {
		if (prices.length <= 1 || prices == null) {
			return 0;
		}
		if (prices.length == 2) {
			if (prices[0]<prices[1]) {
				return prices[1]-prices[0];
			}else{
				return 0;
			}
		}
		int profit = 0;
		for (int i = 1; i < prices.length - 1; i++) {
			int max = maxProfit(prices, 0, i);
			max += maxProfit(prices, i, prices.length - 1);
			profit = Math.max(max, profit);
		}
		return profit;
	}
	
	
	public int maxProfit(int[] prices, int start, int end) {
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for (int i = start; i <= end; i++) {
			min = Math.min(prices[i], min);
			profit = Math.max(profit, prices[i] - min);
		}
		return profit;
	}
	
	public  int  maxProfiIII(int[] prices){
		if (prices.length <= 1 || prices == null) {
			return 0;
		}
		// left[i]表示以i为界限，左边买卖一次股票可获取的最大利益
		int[] left=new  int[prices.length];
		// right[i]表示以i为界限，右边买卖一次股票可获取的最大利益
		int[] right=new int[prices.length];
		//计算left数组
		left[0]=0;
		int min=prices[0];
		for (int i = 1; i < right.length; i++) {
			min=Math.min(min, prices[i]);
			left[i]=Math.max(left[i-1], prices[i]-min);
		}
		//计算right数组
		right[prices.length-1]=0;
		int max=prices[prices.length-1];
		for (int i = prices.length-2; i >=0; i--) {
			max=Math.max(max, prices[i]);
			right[i]=Math.max(right[i+1], max-prices[i]);
		}
		//两次买卖获利总和
		int profit=0;
		for (int i = 0; i < right.length; i++) {
			profit=Math.max(profit, left[i]+right[i]);
		}
		return profit;
	}
    /**
     * @param K
     * @param prices
     * @return
     * @Description 
描述控制台
393. 买卖股票的最佳时机 IV
假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
设计一个算法来找到最大的利润。你最多可以完成 k 笔交易。
样例
给定价格 = [4,4,6,1,1,4,2,5], 且 k = 2, 返回 6.
挑战
O(nk) 时间序列。
     */
	 public int maxProfit(int K, int[] P) {
	        int n = P.length;
	        if (n == 0) {
	            return 0;
	        }
	        
	        int i, j, k;
	        if (K > n / 2) {
	            // best time to buy and sell stock ii
	            int tmp = 0;
	            for (i = 0; i < n - 1; ++i) {
	                tmp += Math.max(0, P[i + 1] - P[i]);
	            }
	            
	            return tmp;
	        }
	        
	        int[][] f = new int[n + 1][2 * K + 1 + 1];
	        for (k = 1; k <= 2 * K + 1; ++k) {
	            f[0][k] = Integer.MIN_VALUE; // impossible
	        }
	        
	        f[0][1] = 0;
	        for (i = 1; i <= n; ++i) {
	            //阶段1, 3, .. 2 * K + 1: f[i][j] = max{f[i-1][j], f[i-1][j-1] + Pi-1 – Pi-2}
	            for (j = 1; j <= 2 * K + 1; j += 2) {
	                f[i][j] = f[i - 1][j];
	                if (j > 1 && i > 1 && f[i - 1][j - 1] != Integer.MIN_VALUE) {
	                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + P[i - 1] - P[i - 2]);
	                }
	            }

	            //阶段2, 4.., 2K: f[i][j] = max{f[i-1][j] + Pi-1 – Pi-2, f[i-1][j-1]}
	            for (j = 2; j <= 2 * K + 1; j += 2) {
	                f[i][j] = f[i - 1][j - 1];
	                if (i > 1 && f[i - 1][j] != Integer.MIN_VALUE) {
	                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + P[i - 1] - P[i - 2]);
	                }
	            }
	        }
	        
	        int res = 0;
	        for (j = 1; j <= 2 * K + 1; j += 2) {
	            res = Math.max(res, f[n][j]);
	        }
	        
	        return res;
	    }
	}



