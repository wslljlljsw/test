package xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split("{|}");
		ArrayList<views> list = new ArrayList<>();
		for(int i = 1; i < s.length-1; i++) {
			list.add(new views(s[i]));
		}
		
		String[] s1 = sc.nextLine().split("{|}");
		List<String> list2 = new ArrayList<>();
		for(int i = 1; i < s1.length-1; i++) {
			city c = new city(s1[i]);
			if(c.level == 5 && c.city == "重庆") list2.add(c.vid);
		}
		
		String result = "";
		for(views v:list) {
			if(list2.contains(v.vid)) result += v.date+":"+v.q+",";
		}
		System.out.println(result.substring(0,result.length()));
	}
}

class city{
	int level;
	String city;
	String vid;
	
	city(String city){
		String[] s = city.split("\"|:|,");
		for(int i = 0; i < s.length; i++) {
			if(s[i] == null) continue;
			if(s[i].equals("level")) {
				while(true) {
					i++;
					if(s[i] == null) continue;
					else {
						level = Integer.valueOf(s[i]);
						break;
					}
				}
			}
			if(s[i].equals("viewspotid")) {
				while(true) {
					i++;
					if(s[i] == null) continue;
					else {
						vid = s[i];
						break;
					}
				}
			}
			if(s[i].equals("city")) {
				while(true) {
					i++;
					if(s[i] == null) continue;
					else {
						city = s[i];
						break;
					}
				}
			}
		}
	}
}
class views{
	String vid;
	String date;
	int q;
	
	views(String view){
		String[] s = view.split("\"|:|,");
		for(int i = 0; i < s.length; i++) {
			if(s[i] == null) continue;
			if(s[i].equals("orderdate")) {
				while(true) {
					i++;
					if(s[i] == null) continue;
					else {
						date = s[i];
						break;
					}
				}
			}
			if(s[i].equals("viewspotid")) {
				while(true) {
					i++;
					if(s[i] == null) continue;
					else {
						vid = s[i];
						break;
					}
				}
			}
			if(s[i].equals("quantity")) {
				while(true) {
					i++;
					if(s[i] == null) continue;
					else {
						q = Integer.valueOf(s[i]);
						break;
					}
				}
			}
		}
	}
}
