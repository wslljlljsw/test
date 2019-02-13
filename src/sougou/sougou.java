package sougou;

import java.util.*;

public class sougou {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		for(int row = 0; row < rows; row++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			sc.nextLine();
			HashSet<Integer> set = new HashSet<>();
			boolean flag = false;
			for(int i = 0; i < N; i++) {
				int num = Integer.valueOf(sc.nextLine(),16);
				if(flag == true) continue; 
				if(num == 0) continue;
				HashSet<Integer> temp_set = new HashSet<>(set);
				temp_set.add(num);
				for(int n : set) {
					int temp_n = n^num;
					if(temp_n == 0 || temp_set.contains(temp_n)) {
						flag = true;
						System.out.println("yes");
						break;
					}
					temp_set.add(temp_n);
				}
				set = temp_set;
			}
			if(flag == false) System.out.println("no");
		}
	}
}
