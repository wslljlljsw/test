package huya;

import java.util.Scanner;

public class huya2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String[] s = sc.nextLine().split(" ");
			StringBuilder sb = new StringBuilder();
			for(int i = s.length-1; i>=0; i--) {
				sb.append(s[i]);
				if(i != 0) sb.append(" ");
			}
			System.out.println(sb.toString());
		}
	}
}
