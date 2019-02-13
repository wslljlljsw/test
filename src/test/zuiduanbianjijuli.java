package test;

import java.util.*;

public class zuiduanbianjijuli {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		String[] v = sc.nextLine().split(" |\t");
		int add = Integer.valueOf(v[0]);
		int delete = Integer.valueOf(v[1]);
		int update = Integer.valueOf(v[2]);
		int add_value,delete_value,update_value;
		
		int[][] distance = new int[a.length()+1][b.length()+1];
		
		for (int i = 0; i < distance.length; i++) {
			distance[i][0] = i*delete;
		}
		for (int i = 0; i < distance[0].length; i++) {
			distance[0][i] = i*add;
		}
		
		for(int i = 1; i < distance.length; i++) {
			for(int j = 1; j < distance[0].length; j++) {
				add_value = distance[i][j-1] + add;
				delete_value = distance[i-1][j] + delete;
				update_value = distance[i-1][j-1] + (a.charAt(i-1) == b.charAt(j-1)?0:update);
				distance[i][j] = add_value < delete_value? (add_value < update_value? add_value:update_value):(delete_value < update_value? delete_value:update_value);
			}
		}
		
		System.out.println(distance[a.length()][b.length()]);
		for(int i = 0; i < a.length()+1; i++) {
			System.out.println();
			for(int j = 0; j < b.length()+1; j++){
				System.out.print(distance[i][j]+"\t");
			}
		}
	}
}
