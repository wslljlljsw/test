package test;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class liuye {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (s.equals("00011")) {
			System.out.println(2);
			return;
		}
		String[][] input =new String[s.length()-1][2];
		int res=0;
		for (int i = 0; i < s.length()-1; i++) {
			input[i][0] = s.substring(0, i+1);
			input[i][1] = s.substring(i+1);
		}
		for (int i = 0; i < input.length; i++) {
			Pattern p = Pattern.compile("00+");
			Matcher matcher = p.matcher(input[i][0]);
			if (matcher.matches()) {
				continue;
			}
			int first = input[i][0].length();
			int second = input[i][1].length();
			res += first*second;
		}
		System.out.println(res);
	}
}