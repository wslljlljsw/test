package dangdang;

import java.util.Scanner;

public class dangdang {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();
		for(int i = 0; i < k; i++) {
			int m = sc.nextInt();
			System.out.print(who(a, b, m));
			if(i != k-1) System.out.print(" ");
		}
	}
	
	private static int who(int a,int b, int m) {
		if(m <= a) return 1;
		if(a < b) return -1;
		if(a > b) return 1;
		if(a == 1) return m%2 == 1? 1:-1;
		if(a > 1) return m % (b+1) == 0? -1:1;
		return 0;
	}
}
