/**
 * 
 */
package com.goodhealth.algorithm.LintCode_Graph;


/**
 * @author 24663
 * @date 2018年9月14日
 * @Description
 */
public class TI_0 {
	public static void main(String[] args) {
		TI_0 ti = new TI_0();
		int[] x = { 0, 0, 2, 2 };
		int[] y = { 0, 2, 0, 2 };
		System.out.println(ti.pnpoly(4, x, y, 3, 2));
	}

	/**
	 * 判断当前位置是否在多边形区域内
	 */
	public boolean pnpoly(int nvert, int[] vertx, int[] verty, int testx, int testy) {
		int i, j, c = 0;
		for (i = 0, j = nvert - 1; i < nvert; j = i++) {
			if (((verty[i] > testy) != (verty[j] > testy))
					&& (testx < (vertx[j] - vertx[i]) * (testy - verty[i]) / (verty[j] - verty[i]) + vertx[i])) {

				if (c == 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

}
