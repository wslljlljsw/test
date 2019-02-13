package neteasy;

import java.util.Scanner;

public class ne2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		String[] s_apple = sc.nextLine().split(" ");
		int m = Integer.valueOf(sc.nextLine());
		String[] s_ask = sc.nextLine().split(" ");
		
		int[] apple = new int[n];
		for(int i = 0; i < n; i++) {
			if(i == 0) apple[i] = Integer.valueOf(s_apple[i]);
			else apple[i] = Integer.valueOf(s_apple[i])+apple[i-1];
		}
		
		for(int i = 0; i < m; i++) {
			int q = Integer.valueOf(s_ask[i]);
			System.out.println(find(q,apple,0,apple.length-1));
		}
	}
	
	public static int find(int q, int[] apple,int left, int right) {
		int mid = (left+right)/2;
		if((mid == 0 && q <= apple[0]) ||
				(q <= apple[mid] && q > apple[mid-1])) {
			return mid+1;
		}
		else if(q < apple[mid]) {
			return find(q,apple,left,mid-1);
		}
		else return find(q,apple,mid+1,right);
	}
}
