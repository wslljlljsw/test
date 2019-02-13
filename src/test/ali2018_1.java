package test;

import java.util.*;

public class ali2018_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = Integer.valueOf(sc.nextLine());
		int column = Integer.valueOf(sc.nextLine());
		int[][] arrays = new int[row][column];
		String[] s;
		for(int i = 0; i < row; i++) {
			s = sc.nextLine().split(" ");
			for (int j = 0; j < column; j++) {
				arrays[i][j] = Integer.valueOf(s[j]);
			}
		}
		long starttime = System.nanoTime();
		getresult(arrays);
		long endtime = System.nanoTime();
		
		long starttime_dp = System.nanoTime();
		getresult_dp(arrays);
		long endtime_dp = System.nanoTime();
		
		System.out.println(endtime - starttime);
		System.out.println(endtime_dp - starttime_dp);
	}
	
	public static void getresult(int[][] arrays){
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = arrays.length-1; i >=0; i--) {
			for (int j = arrays[0].length-1; j >= 0; j--) {
				if(arrays[i][j] == 0 && max == 0) {
					stack.push(i*arrays[0].length+j);
				}
				else if(arrays[i][j] == 1) {
					int row_value = 0,column_value = 0;
					int m = 0,n = 0;
					for(m = j; m >= 0; m--) {
						if(arrays[i][m] == 0) {
							m = m+1;
							break;
						}
					}
					for(n = j; n < arrays[0].length; n++) {
						if(arrays[i][n] == 0) {
							n = n-1;
							break;
						}
					}
					m = m < 0? 0:m;
					n = n > (arrays[0].length-1)? (arrays[0].length-1):n;
					row_value = n - m + 1;
//					System.out.println(m+" "+n);
					
					for(m = i; m >= 0; m--) {
						if(arrays[m][j] == 0) {
							m = m+1;
							break;
						}
					}
					for(n = i; n < arrays.length; n++) {
						if(arrays[n][j] == 0) {
							n = n-1;
							break;
						}
					}
					m = m < 0? 0:m;
					n = n > (arrays.length-1)? (arrays.length-1):n;
//					System.out.println(m+" "+n);
					column_value = n - m + 1;
					
					int cur_max = row_value + column_value - 1;
					
//					System.out.println(i+"___"+j+"="+row_value+"____"+column_value);
					if(cur_max > max) {
						max = cur_max;
						stack.clear();
						stack.push(i*arrays[0].length+j);
					}
					else if(cur_max == max) {
						stack.push(i*arrays[0].length+j);
					}
				}
			}
		}
		
//		System.out.println(stack.size());
		for(int i = stack.size(); i > 0; i--) {
			int num = stack.pop();
			int cur_row = num/arrays[0].length;
			int cur_column = num%arrays[0].length;
			System.out.println(cur_row+" "+cur_column);
		}
	}
	
	public static void getresult_dp(int[][] arrays) {
		int[][] row = new int[arrays.length][arrays[0].length];
		int[][] column = new int[arrays.length][arrays[0].length];
		
		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < row[0].length; j++) {
				if(arrays[i][j] == 0) {
					row[i][j] = 0;
					continue;
				}
				if(j == 0) {
					row[i][j] = 0;
					for(int m = j; m < arrays[0].length; m++) {
						if(arrays[i][m] == 0) {
							break;
						}
						row[i][j]++;
					}
				}
				else {
					if(arrays[i][j-1] == 1) {
						row[i][j] = row[i][j-1];
					}
					else{
						row[i][j] = 0;
						for(int m = j; m < arrays[0].length; m++) {
							if(arrays[i][m] == 0) {
								break;
							}
							row[i][j]++;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < column.length; i++) {
			for (int j = 0; j < column[0].length; j++) {
				if(arrays[i][j] == 0) {
					column[i][j] = 0;
					continue;
				}
				if(i == 0) {
					column[i][j] = 0;
					for(int m = i; m < arrays.length; m++) {
						if(arrays[m][j] == 0) {
							break;
						}
						column[i][j]++;
					}
				}
				else {
					if(arrays[i-1][j] == 1) {
						column[i][j] = column[i-1][j];
					}
					else {
						column[i][j] = 0;
						for(int m = i; m < arrays.length; m++) {
							if(arrays[m][j] == 0) {
								break;
							}
							column[i][j]++;
						}
					}
				}
			}
		}
		
		int max = 0;
		int cur_max = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[0].length; j++) {
				cur_max = row[i][j] + column[i][j] - 1;
				if(cur_max == max) {
					list.add(i*arrays[0].length+j);
				}
				else if(cur_max > max) {
					list.clear();
					max = cur_max;
					list.add(i*arrays[0].length+j);
				}
			}
		}
		
//		for (int i = 0; i < arrays.length; i++) {
//			System.out.println();
//			for (int j = 0; j < arrays[0].length; j++) {
//				System.out.print(row[i][j]+" ");
//			}
//		}
//		
//		for (int i = 0; i < arrays.length; i++) {
//			System.out.println();
//			for (int j = 0; j < arrays[0].length; j++) {
//				System.out.print(column[i][j]+" ");
//			}
//		}
		
		int row_value,column_value;
		for(int a : list) {
			row_value = a/arrays[0].length;
			column_value = a%arrays[0].length;
			System.out.println(row_value+" "+column_value);
		}
	}
}

