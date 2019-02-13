package test;

import java.util.*;

public class huawei2018_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String[] s = sc.nextLine().split(" ");
			int init_year = 1900;
			int years = Integer.valueOf(s[0]);
			int weeks = Integer.valueOf(s[1]);
			if(years <= 0 || years > 400 || weeks < 0 || weeks > 6) {
				System.out.println(-1);
				return;
			}
			Calendar cal = Calendar.getInstance();
//			cal.set(1900,0,1);
//			System.out.println((cal.get(Calendar.DAY_OF_WEEK)));
			int count = 0;
			for(int i = 0; i < years; i++) {
				for(int j = 0; j < 12; j++) {
					cal.set(init_year+i, j, 13);
					if((cal.get(Calendar.DAY_OF_WEEK)-1)%7 == weeks) {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}