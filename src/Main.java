import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String[] s = sc.nextLine().split(" ");
//		System.out.println(s[s.length-1].length());
		String s = sc.nextLine();
		String end = sc.nextLine();
		
		int count = 0;
		for (int i = 0; i < s.length()-1; i++) {
			if(end.equalsIgnoreCase(s.substring(i, i+1))) count++;	
		}
		System.out.println(count);
	}
}
