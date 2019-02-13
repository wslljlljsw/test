package toutiao;

import java.util.Scanner;

public class toutiaod2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[][] array = new int[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(array[i][j] == 0) continue;
				count++;
				visit(i, j, m, array);
			}
		}
		
		System.out.println(count);
	}
	
	public static void visit(int i,int j, int m, int[][] array) {
		array[i][j] = 0;
		if((i > 0 && array[i-1][j] == 1)) visit(i-1,j,m,array);
		else if(i < m-1 && array[i+1][j] == 1)  visit(i+1,j,m,array);
		else if(j > 0 && array[i][j-1] == 1) visit(i,j-1,m,array);
		else if(j < m-1 && array[i][j+1] == 1) visit(i,j+1,m,array);
	}
}
