package test;

import java.util.Scanner;


public class toutiao2017_3 {

    private static int num;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            num = 0;
            int n = scan.nextInt();
            int k = scan.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = scan.next();
            }
            permutation(strs, 0, strs.length - 1, k);
            System.out.println(num);
        }
        scan.close();
    }

    /**
     * 从集合中依次选出每一个元素，作为排列的第一个元素，然后对剩余的元素进行全排列，如此递归处理.
     *
     * @param strs
     * @param start
     * @param end
     */
    private static void permutation(String[] strs, int start, int end,int k) {
        if (start == end) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= end; i++) {
                sb.append(strs[i]);
            }
            sovle(sb.toString(),k);
            return;
        }
        for (int i = start; i <= end; i++) {
            if (i != start){
                swap(strs, i, start);
            }
            permutation(strs, start + 1, end,k);//固定好当前一位，继续排列后面的
            if (i != start){
                swap(strs, i, start);
            }
        }
    }

    private static void sovle(String str, int k) {
        int count = 0;
        String s = str + str;
        for (int i = 1, len = str.length(); i <= len; i++) {
            if (str.equals(s.substring(i,i+len))) {
                ++count;
            }
        }
        if (count == k) {
            ++num;
        }
    }

    private static void swap(String[] strs, int i, int start) {
        String temp = strs[start];
        strs[start] = strs[i];
        strs[i] = temp;
    }
}