package jd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class jd1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] array = new int[N][N];
			for(int j = 0; j < M; j++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				array[X-1][Y-1] = 1;
				array[Y-1][X-1] = 1;
			}
			System.out.println(getresult(array) ? "Yes":"No");
		}
	}

	public static boolean getresult(int[][] array) {
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		for(int i = 0; i < array.length; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int j = 0; j < array.length; j++) if(array[i][j] == 0) list.add(j);
			if(list.size() > 0) set.add(list);
		}
		int all = array.length;
		for (ArrayList<Integer> list: set) all -= list.size();
		return all == 0;
	}
}