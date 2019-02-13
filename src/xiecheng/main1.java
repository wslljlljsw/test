package xiecheng;

import java.util.Scanner;

public class main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		char[][] arr = new char[10][10];
		int len = Math.abs(y1-y2);
		
		int li = y1-1,lj = y1-1, ri = y2-1, rj = y2-1;
		boolean flag = true;
		for(int i = 0; i < 10; i++) {
			if(i >= x1 - 1 + len/2) flag = false;
			for(int j = 0; j < 10; j++) {
				if(i < x1-1) {
					arr[i][j] = '-';
					continue;
				}
//				System.out.println(i+" "+li+" "+lj);
//				System.out.println(i+" "+ri+" "+rj);
				if(flag == true && ((j >= li && j <= lj) ||
						(j >= ri && j <= rj))) {
					arr[i][j] = '#';
				}
				else if(flag == false && (j >= li && j <= rj)) {
					arr[i][j] = '#';
				}
				else arr[i][j] = '-';
			}
			if(i < x1-1) continue;
			if(len%2 == 1 && i == x1+len/2-1) continue;
			if(flag == true) {
				li--;
				lj++;
				ri--;
				rj++;
			}
			else {
				li++;
				lj--;
				ri++;
				rj--;
			}
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(arr[i][j]);
				if(j != 9) System.out.print(" ");
			}
			System.out.println();
		}
	}
}
