package test;

import java.util.*;
public class niuke {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] ca = s.toCharArray();  //字符数组，方便交换
		List<String> result = new ArrayList<>();  //用于存放结果集
		getresult(ca, 0, result);  //遍历所有可能组合
		Collections.sort(result);  //结果集排序
		for(String str: result) {
			System.out.println(str);  //输出结果
		}
	}
	
	/**
	 * 返回当前字符数组所有可能的排列组合
	 * @param ca 字符数组
	 * @param index 当前需要和后续位置交换的索引位
	 * @param result 结果集
	 */
	public static void getresult(char[] ca, int index, List<String> result) {
		if(index == ca.length-1) result.add(String.valueOf(ca));  //索引位到达数组末尾，没有需要交换的后续位置了，将该结果添加到结果集
		for(int i = index; i < ca.length; i++) { //当前索引位和后续每一位互相交换
			if(i != index && ca[i] == ca[index]) continue; //如果字符相同，则已经遍历过该结果了，跳过
			swap(ca,index,i);
			getresult(ca, index+1, result);
			swap(ca,index,i);
		}
	}
	
	public static void swap(char[] ca, int i, int j) {
		char temp = ca[i];
		ca[i] = ca[j];
		ca[j] = temp;
	}
}
