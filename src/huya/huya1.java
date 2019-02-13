package huya;

import java.util.Scanner;

public class huya1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			s = s.replaceAll(" ","");
			String result = "";
			StringBuilder sb = new StringBuilder(s);
			if(sb.length() > 6) sb.insert(6, " ");
			if(sb.length() > 16) sb.insert(15, " ");
			System.out.println(sb.toString());
		}
	}
}
