package test;

import java.util.*;

public class qunaier_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" |\t");
		int n = Integer.valueOf(s[0]);
		int allseat = Integer.valueOf(s[1]);
		s = sc.nextLine().split(" |\t");
		int[] seat = new int[n];
		for(int i = 0; i < n; i++) {
			seat[i] = Integer.valueOf(s[i]);
		}
		
		long starttime = System.nanoTime();
		boolean result = getresult(allseat, seat, -1);
		if(result == true) System.out.println("prefect");
		else System.out.println("good");
		long endtime = System.nanoTime();
		System.out.println(endtime - starttime);
		
		long starttime1 = System.nanoTime();
		result = dp(allseat,seat);
		if(result == true) System.out.println("prefect");
		else System.out.println("good");
		long endtime1 = System.nanoTime();
		System.out.println(endtime1 - starttime1);
		
	}
	
	public static boolean getresult(int allseat,int[] seat,int n) {
		if(allseat < 0) return false;
		for(int i = n+1; i < seat.length; i++) {
			allseat = allseat - seat[i];
			if(allseat == 0) return true;
			else if(allseat < 0) {
				allseat = allseat + seat[i];
			}
			else {
				boolean result = getresult(allseat,seat,i);
				if(result == true)  return true;
				else {
					allseat = allseat + seat[i];
					result = getresult(allseat,seat,i);
					if(result == true) return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean dp(int allseat, int[] seat) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> temp_set = new HashSet<Integer>();
		set.add(0);
		for (int i = 0; i < seat.length; i++) {
			for (int a : set) {
				if(a+i < allseat) temp_set.add(a+i);
				else if(a+i == allseat) {
					return true;
				}
			}
			set.addAll(temp_set);
			temp_set.clear();
		}
		return false;
	}
}
