package test;

import java.util.*;
import java.util.Map.Entry;

/**
 * 
;test case
@author lilingjie
[section1]
key2 = value2
key1 = value1
;test
key3 = value3
[section2]
key4 = value4
key3 = value3
key1 = value1
key2 = value2
 * @author lilingjie
 *
 */

public class huawei2018_3_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<section> list = new ArrayList<>();
		String s = sc.nextLine();
		while(!s.equals("")) {
			if(s.charAt(0) == ';') {
				s = sc.nextLine();
				continue;
			}
			if(s.charAt(0) == '[') {
				section sec = new section(s.substring(1, s.length()-1));
				list.add(sec);
				while(sc.hasNextLine()) {
					s = sc.nextLine();
					if(s.equals("")) break;
					if(s.charAt(0) == ';') continue;
					if(s.charAt(0) == '[') break;
					String[] kv = s.split("=");
					sec.put(kv[0], kv[1]);
				}
			}
			else s = sc.nextLine();
			if(s.equals("")) break;
		}
		list.sort(new Comparator<section>() {
			@Override
			public int compare(section o1, section o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		
		for(section sec : list) {
			sec.getall();
		}
		
		if(list.size() == 0) System.out.println("");
	}
}

class section{
	String name = "";
	Map<String,String> map = new TreeMap<>(new Comparator<String>() {
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		};
	});
	
	public section(String name) {
		this.name = name;
	}
	
	public void put(String key,String value) {
		key = key.trim();
		value = value.trim();
		map.put(key, value);
	}
	
	public void getall() {
		for(Entry<String, String> e: map.entrySet()) {
			System.out.println("{"+name+"}"+"{"+e.getKey()+"}"+"{"+e.getValue()+"}");
		}
	}
	
}
