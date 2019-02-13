package huya;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class huya4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        String str[]=s.split(" ");
        LinkedHashMap<Character, Integer>map=new LinkedHashMap<Character, Integer>();
        for(int i=0;i<str.length;i++){
        	String temp=str[i];
        	for(int j=0;j<temp.length();j++){
        		if(map.containsKey(temp.charAt(j)))
        			map.put(temp.charAt(j),map.get(temp.charAt(j))+1);
        		else
        			map.put(temp.charAt(j),1);
        	}
        }
        char result=' ';
        for(Map.Entry<Character, Integer>m:map.entrySet()){
        	if('A'<=m.getKey()&&m.getKey()<='z'&&m.getValue()==3){
        		result=m.getKey();
        		break;
        	}
        }
        System.out.println(result);
 }
}
