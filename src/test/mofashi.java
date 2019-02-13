package test;

import java.io.InputStream;
import java.util.Scanner;

public class mofashi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int t = Integer.valueOf(s);
		int[][] a = new int[t*2][4];
		String[] ss;
		for(int i = 0; i < t*2; i++) {
			ss = sc.nextLine().split(" |\t");
			for(int j = 0; j < 4; j++) {
				a[i][j] = Integer.valueOf(ss[j]);
			}
		}
		for(int i = 0; i < t; i++) {
			double k1 = a[i][1] == a[i][2]? null:(a[i][1]-a[i][2])/(a[i+1][1] - a[i+1][2]);
			double k2 = a[i][1] == a[i][2]? null:(a[i][1]-a[i][2])/(a[i+1][1] - a[i+1][2]);
			double k3 = a[i][1] == a[i][2]? null:(a[i][1]-a[i][2])/(a[i+1][1] - a[i+1][2]);
		}
	}

}
