package test;

import java.sql.Time;

public class jingdong2018_2_1 {
	public static void main(String[] args) {
		Time t = new Time(8, 0, 0); //时分秒
		
		int[] record_test = new int[86400]; //60秒*60分*24小时
		for (int i = 0; i < record_test.length; i++) {
			record_test[i] = (int)Math.floor(Math.random()*100); //模拟一天的数据
		}
		
		/*
		 * 由于前面的数据随机的，70%的80不太容易出现，故70%的30，测试用
		 * record,1小时,70%,大于30
		 */
		int timelength = getresult(record_test,3600,0.7,30); 
		if(timelength == -1) {
			System.out.println("无法找到满足条件的时间窗口");
			return;
		}
		
		t.setSeconds(t.getSeconds()+timelength); //当前时间窗口的开始时间
		System.out.println(t.toString());
	}
	
	/**
	 * 
	 * @param record 采集到的记录数组
	 * @param timelength 要求匹配的窗口时间
	 * @param percent 要求满足的百分比
	 * @param value 要求达到要求的value值
	 * @return 第一个满足条件的窗口的头坐标
	 */
	public static int getresult(int[] record,int timelength,double percent,int value) {
		int goal = (int)Math.ceil(timelength*percent);
		int cur_amount = 0;
		for(int i = 0; i < record.length;i++) {
			if(i < timelength) { //当前i小于窗口数量时，直接记录
				if(record[i] > value) cur_amount++;
				if(i == timelength-1 && cur_amount >= goal) return 0; //达到窗口数量时，判断是否满足标准，满足则返回该窗口头坐标
			}
			if(i >= timelength) { //当前i大于窗口数量时,cur_amount减去（i-timelength）坐标的结果，加上当前i的结果,然后判断是否满足标准
				if(record[i-timelength] > value) cur_amount--;
				if(record[i] > value) cur_amount++;
				if(cur_amount >= goal) return i-timelength+1;
			}
		}
		return -1; //未找到满足标准的窗口则返回-1
	}
}
