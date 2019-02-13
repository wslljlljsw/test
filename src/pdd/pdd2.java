package pdd;

import java.util.*;

public class pdd2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		if((N-N/2)*N/2 < K) System.out.println("-");
		else System.out.println(getmax(N, K));
	}
	
	private static String getmax(int N,int K) {
		if(K == 0) {
			String result = "";
			for(int i = 0; i < N; i++) result += "B";
			return result;
		}
		
		int min = N+1;
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i < N; i++) {
			int numB = (int) Math.ceil(K*1.0/i);
			if(i+numB < min) {
				list.clear();
				list.add(i);
				min = i+numB;
			}
			else if(i + numB == min) {
				list.add(i);
			}
		}
		
		String result = "";
		for(int i = N; i > min; i--) result += "B";
		result += "A";
		
		String max = "";
		for(int i : list) {
			String curmax = getmax(min-1, K-(min-i));
			if(max.compareTo(curmax) < 0) max = curmax;
		}
		return result+max;
	}
}
