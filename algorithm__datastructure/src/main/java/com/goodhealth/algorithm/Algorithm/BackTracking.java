package com.goodhealth.algorithm.Algorithm;
//   回溯算法解决八皇后问题
public class BackTracking{
	public static int num = 0;
	public static final int MAXQUEEN = 8;
	public static int[] cols = new int[MAXQUEEN];
	
	
	public void getCount(int n){
		boolean [] rows = new boolean[MAXQUEEN];
		for(int m = 0;m<n;m++){
			rows[cols[m]] = true;
			int d = n - m;
			if(cols[m]-d>=0){
				rows[cols[m] -d] = true;
			}
			if(cols[m]+d<=(MAXQUEEN-1)){
				rows[cols[m]+d] = true;
			}
		}
		for(int i = 0;i<MAXQUEEN;i++){
			if(rows[i]){
				continue;
			}
			cols[n] = i;
			if(n<MAXQUEEN-1){
				getCount(n+1);
			}else{
				num++;
				printQueen();
			}
		}
	}

	private void printQueen() {
		System.out.println("第"+num+"种情况");
		for(int i = 0;i<MAXQUEEN;i++){
			for(int j = 0;j<MAXQUEEN;j++){
				if(i == cols[j]){
					System.out.print("0 ");
				}else{
					System.out.print("+ ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		BackTracking queen = new BackTracking();
		queen.getCount(0);
	}
}
