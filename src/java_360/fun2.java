package java_360;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class fun2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n =scanner.nextInt();
		int m = scanner.nextInt();
		int[] a =new int[n];
		for (int  i= 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int q =scanner.nextInt();
		int[] res =new int[q];
		int begin=0,end = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < q; i++) {
			begin = scanner.nextInt();
			end = scanner.nextInt();
			for (int j = begin-1; j < end; j++) {
				set.add(a[j]);
			}
			res[i] = set.size();
			set.clear();
		}
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
