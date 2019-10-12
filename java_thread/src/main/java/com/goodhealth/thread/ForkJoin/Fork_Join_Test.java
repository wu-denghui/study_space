package com.goodhealth.thread.ForkJoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author 24663
 * @date 2018年12月8日
 * @Description  使用forkjoin框架完成归并排序
 */
public class Fork_Join_Test {
	private static int MAX = 100;
	private static int inits[] = new int[MAX];
	static {
		Random r = new Random();
		for (int i = 0; i < inits.length; i++) {
			inits[i] = r.nextInt(100000);
		}
	}

	public static void main(String[] args) throws Exception {
		long beginTime = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool();  //1
		MyTask task = new MyTask(inits);           //2
		ForkJoinTask<int[]> taskResult = pool.submit(task);//      3     <T> T是任务的返回类型
		try {
			taskResult.get();//获得大任务的结果      4
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}finally {
			pool.shutdown();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("耗时=" + (endTime - beginTime));
	}

	static class MyTask extends RecursiveTask<int[]> {//<T> T是任务的返回类型
		private int source[];
		public MyTask(int source[]) {
			this.source = source;

		}
		@Override
		protected int[] compute() {
			int sourceLen = source.length;
			// 如果条件成立，说明任务中要进行排序的集合还不够小
			if (sourceLen > 2) {
				int midIndex = sourceLen / 2;
				// 拆分成两个子任务
				MyTask task1 = new MyTask(Arrays.copyOf(source, midIndex));
				task1.fork();
				MyTask task2 = new MyTask(Arrays.copyOfRange(source, midIndex, sourceLen));
				task2.fork();
				// 将两个有序的数组，合并成一个有序的数组
				int result1[] = task1.join();
				int result2[] = task2.join();
				int mer[] = joinInts(result1, result2);
				return mer;
			} else {// 否则说明集合中只有一个或者两个元素，可以进行这两个元素的比较排序了
				if (sourceLen == 1 || source[0] <= source[1]) {
					// 如果条件成立，说明数组中只有一个元素，或者是数组中的元素都已经排列好位置了
					return source;
				} else {
					int targetp[] = new int[sourceLen];
					targetp[0] = source[1];
					targetp[1] = source[0];
					return targetp;
				}
			}
		}
	/**
	 * @param arr1
	 * @param arr2
	 * @return
	 * @Description 将分开的数组归并
	 */
	private  int[] joinInts(int[] arr1, int[] arr2) {
		int left = 0;
		int right = 0;
		int[] mergeArr = new int[arr1.length + arr2.length];
		if (mergeArr.length == 0)
			return null;
		for (int i = 0; i < arr1.length + arr2.length; i++) {
			if (arr1.length == left) {
				mergeArr[i] = arr2[right];
				right++;
				continue;
			} else if (arr2.length == right) {
				mergeArr[i] = arr1[left];
				left++;
				continue;
			}
			if (arr1[left] <= arr2[right]) {
				mergeArr[i] = arr1[left];
				left++;
			} else {
				mergeArr[i] = arr2[right];
				right++;
			}
		}
		return mergeArr;
	}

}

}