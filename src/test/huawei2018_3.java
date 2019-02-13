package test;

import java.text.DecimalFormat;
import java.util.*;

public class huawei2018_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());
			if(n <= 0) {
				System.out.println("[]");
				return;
			}
			double[][] result = new double[6*n-n+1][2];
			for(int i = 0; i < result.length; i++) {
				result[i][0] = i + n;
			}
			dice(result,n,1,0);
			long sum = 1;
			for(int i = 0; i < n; i++) {
				sum = 6*sum;
			}
			
			DecimalFormat df = new DecimalFormat();  
	        df.setMinimumFractionDigits(5);
			for(int i = 0; i < result.length; i++) {
				result[i][1] = Double.valueOf(df.format(result[i][1]/sum));
			}
			result = dice(n);
			String ss = "[";
			for(int i = 0; i < result.length; i++) {
				if(i > 0) ss += ", ";
				ss += "[";
				ss += String.valueOf((int)result[i][0]);
				ss += ", ";
//				ss += String.valueOf(result[i][1]);
				ss += df.format(result[i][1]);
				ss += "]";
			}
			ss += "]";
			System.out.println(ss);
	        
//			String[][] result2 = new String[6*n-n+1][2];
//			for(int i = 0; i < result.length; i++) {
//				result2[i][0] = String.valueOf((int)result[i][0]);
//				result2[i][1] = df.format(result[i][1]);
//			}
//			System.out.println(result2);
	        
//			System.out.print("[");
//			for(int i = 0; i < result.length; i++) {
//				if(i > 0) System.out.print(",");
//				System.out.printf("[%.0f,%.5f]",result[i][0],result[i][1]);
////				System.out.printf(result[i][0]+","+result[i][1]);
//			}
//			System.out.println("]");
		}
	}
	
	public static void dice(double[][] result,int n,int cur,int cur_value) {
		if(n == cur) {
			for(int i = 1; i <= 6; i++) {
				result[cur_value+i-n][1]++;
			}
			return;
		}
		for(int i = 1; i <= 6; i++) {
			dice(result,n,cur+1,cur_value+i);
		}
	}
	public static double[][] dice(int n) {
		double[][] old = new double[6*n+1][2];
		for(int i = 1; i <= 6; i++) {
			old[i][1] = 1;
		}
		for(int i = 1; i < n; i++) {
			double[][] cur = new double[6*n+1][2];
			for(int j = 1; j < 6; j++) {
				for(int index = i; index <= 6*i; index++) {
					cur[index+j][1] += old[index][1]; 
				}
			}
			old = cur;
		}
		int sum = 0;
		for (int i = 0; i < old.length; i++) {
			sum += old[i][1];
		}
		double[][] result = new double[6*n-n+1][2];
		for(int i = n; i <= 6*n; i++) {
			result[i-n][0] = i;
			result[i-n][1] = old[i][1]/sum;
		}
		return result;
	}
	
}