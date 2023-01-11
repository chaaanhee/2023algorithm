package baekjoon;

import java.util.Scanner;

public class 평균구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//배열선언
		int arr[] = new int[N];
		
		//scanner로 받은 값을 배열로 저장
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		long sum = 0;
		double avg;
		
		// max 값을 0으로 지정
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		// 100.0 으로 소수점값까지 받기 -> avg는 double형 
		avg = sum * 100.0 / max / N;
		System.out.println(avg);
	}
}
