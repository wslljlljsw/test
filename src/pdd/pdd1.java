package pdd;

import java.util.*;

public class pdd1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		int[] result = new int[M-N+1];
		result[0] = needtoadd(0,N,list);
		int min = result[0];
		for(int i = N; i < M; i++) {
			result[i-N+1] = result[i-N] + (list.get(i) - list.get(i-1))*(N-1) - (list.get(i-1) - list.get(i-N));
			min = Math.min(min, result[i-N+1]);
		}
		System.out.println(min);
	}
	
	private static int needtoadd(int index, int N, List<Integer> list) {
		int sum = 0;
		int max = list.get(N+index-1);
		for(int i = index; i < N+index-1; i++) sum += max - list.get(i);
		return sum;
	}
}
