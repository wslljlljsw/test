package test;

import java.util.Scanner;

public class shuzizifu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] num = new int[10];
		for(int i = 0; i < s.length(); i++) {
			num[s.charAt(i)-'0']++;
		}
		int leastnum = 0;
		for(int i = 1; i < 10; i++) {
			if(num[i] < num[leastnum]) {
				leastnum = i;
			}
		}
		
		String result = "";
		if(s.equals("")) {
			result = "1";
		}
		else if(leastnum != 0) {
			for(int i = 0; i <= num[leastnum]; i++) {
				result = result + String.valueOf(leastnum);
			}
		}
		else {
			int nextleastnum = 1;
			for(int i = 1; i < 10; i++) {
				if(num[i] < num[nextleastnum]) {
					nextleastnum = i;
				}
			}
			if(num[nextleastnum] == 0) {
				result = String.valueOf(nextleastnum);
			}
			if(num[nextleastnum] == num[0]) {
				for(int i = 0; i <= num[nextleastnum]; i++) {
					result = result + String.valueOf(nextleastnum);
				}
			}
			else{
				int nextnum = 0;
				for(int i = 1; i < 10; i++) {
					if(num[i] != 0) {
						nextnum = i;
						break;
					}
				}
				result = String.valueOf(nextnum);
				for(int i = 0; i <= num[leastnum]; i++) {
					result = result + String.valueOf(leastnum);
				}
			}
		}
		System.out.println(result);
	}
}
