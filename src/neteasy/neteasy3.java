package neteasy;

import java.util.Scanner;

public class neteasy3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//投票者个数
		int m = sc.nextInt();//候选人个数
		int[] all = new int[m];
		int[][] every = new int[n][2];
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();//投票对象
			int y = sc.nextInt();//改变代价
			all[x-1]++;
			every[i][0] = x-1;
			every[i][1] = y;
		}
		int count = 0;
		while(!isbest(all)) {
			int max = getmax(all);
			int nextnum = next(max, every, all);
			all[0]++;
			all[every[nextnum][0]]--;
			every[nextnum][0] = 0;
			count += every[nextnum][1];
		}
		System.out.println(count);
	}
	
	public static int getmax(int[] all) {
		int max = 0;
		for(int i = 0; i < all.length; i++) {
			max = Math.max(max, all[i]);
		}
		return max;
	}
	
	public static boolean isbest(int[] all) {
		for(int i = 1; i< all.length; i++) {
			if(all[i] >= all[0]) return false;
		}
		return true;
	}
	
//	public static int maxnum(int[] all, int max) {
//		int count = 0;
//		for(int i = 1; i < all.length; i++) {
//			if(all[i] == max) count++;
//		}
//		return count;
//	}
	
	public static int next(int max, int[][] every,int[] all) {
		int num = -1;
		double value = Double.MAX_VALUE;
		for(int i = 0; i < every.length; i++) {
			if(every[i][0] == 0) continue;
			if(max - all[0] > 1 && all[every[i][0]] == max) {
				double temp = every[i][1]/2;
				if(temp < value) {
					value = temp;
					num = i;
				}
			}
			else {
				double temp = every[i][1];
				if(temp < value) {
					value = temp;
					num = i;
				}
			}
		}
		return num;
	}
}
