package test;

public class weiruan_cn_3 {
	public static void main(String[] args) {
		int[] inputList = new int[] {20,13,4,5,8,10};
		int[][] listOfOp = new int[][] {
			{1,2,3,2},
			{3,1,4,1},
			{2,5,6,5},
			{4,1,6,0},
			{3,2,4,2}};
			
		for(int i = 0; i < listOfOp.length;i++) {
			if(listOfOp[i][0] == 1) {
				for(int j = listOfOp[i][1]-1; j < listOfOp[i][2]; j++) {
					inputList[j] = inputList[j] + listOfOp[i][3];
				}
			}
			if(listOfOp[i][0] == 2) {
				for(int j = listOfOp[i][1]-1; j < listOfOp[i][2]; j++) {
					inputList[j] = inputList[j] - listOfOp[i][3];
				}
			}
			if(listOfOp[i][0] == 3) {
				for(int j = listOfOp[i][1]-1; j < listOfOp[i][2]; j++) {
					inputList[j] = listOfOp[i][3];
				}
			}
			if(listOfOp[i][0] == 4) {
				int sum = 0;
				for(int j = listOfOp[i][1]-1; j < listOfOp[i][2]; j++) {
					sum  = sum + inputList[j];
				}
				for(int j = 0; j < inputList.length; j++) {
					inputList[j] = inputList[j] + sum;
				}
			}
		}
		
		String result = "";
		for (int i = 0; i < inputList.length; i++) {
			if(i == 0) {
				result = result + "[";
			}
			result = result + inputList[i]+",";
		}
		result = result.substring(0, result.length()-1);
		result = result + "]";
		
		System.out.println(result);
	}
}
