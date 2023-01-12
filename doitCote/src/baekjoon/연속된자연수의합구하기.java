package baekjoon;

import java.util.Scanner;

public class 연속된자연수의합구하기 {

	public static void main(String[] args) {
		// sum == N는 end_index++; sum = sum + end_index; count++;
		// sum > N 는 sum = sum - start_index; start_index++;
		// sum < N 는 end_index++; sum = sum + end_index;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//count가 1 이유 : (end_index == N) 값을 처음부터 초기화
		int count = 1;
		int start_index = 1;
		int end_index = 1;
		int sum = 0;
		
		while(end_index != N) {
			if(sum < N) {
				sum = sum + end_index;
				end_index++;
			} else if(sum == N) {
				sum = sum + end_index;
				count++;
				end_index++;
			} else if(sum > N) {
				sum = sum - start_index;
				start_index++;
			}
		}
		
		System.out.println(count);
	}

}
