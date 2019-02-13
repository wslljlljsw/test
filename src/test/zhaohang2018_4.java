package test;

import java.util.*;

public class zhaohang2018_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.valueOf(sc.nextLine());
		
		String[] s;
		int n,k;
		int[] v;
		for(int i = 0; i < t; i++) {
			s = sc.nextLine().split(" ");
			n = Integer.valueOf(s[0]);
			k = Integer.valueOf(s[1]);
			s = sc.nextLine().split(" ");
			v = new int[s.length];
			for (int j = 0; j < s.length; j++) {
				v[j] = Integer.valueOf(s[j]);
//				System.out.println(v[j]);
			}
			Arrays.sort(v);
			int[][] result = new int[k+1][v.length];
			for(int vi = 0; vi < v.length; vi++) {
				result[0][vi] = 1;
			}
			for(int j = 1; j < k+1; j++) {
				for(int vi = 0; vi < v.length; vi++) {
					if(v[vi] < j) {
						for(int vi2 = 0; vi2 <= vi; vi2++) {
							result[j][vi] += result[j-v[vi]][vi2];
						}
					}
					else if(v[vi] == j) {
						result[j][vi] = 1;
					}
					else break;
				}
			}
			
//			for (int j = 0; j < result.length; j++) {
//				for (int j2 = 0; j2 < result[0].length; j2++) {
//					System.out.print(result[j][j2]+"\t");
//				}
//				System.out.println();
//			}
			int sum = 0;
			for(int vi = 0; vi < v.length; vi++) {
				sum += result[k][vi];
			}
			System.out.println(sum);
		}
	}
}
