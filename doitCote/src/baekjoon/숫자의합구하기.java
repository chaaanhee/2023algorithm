package baekjoon;

import java.util.Scanner;

public class 숫자의합구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String sNum = sc.next();
		
		//sNum -> char[]으로 변환
		//sum += (charArr[i] - 48) 
		// 48은 아스키코드로 '0'		
		int sum = 0;
		char[] charArr = sNum.toCharArray();
		for(int i = 0; i < charArr.length; i++) {
			sum += (charArr[i] - 48);
		}
		System.out.println(sum);
	}
}