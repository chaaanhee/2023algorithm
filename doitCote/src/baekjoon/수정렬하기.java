package baekjoon;

import java.util.Scanner;

public class 수정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// arr의 길이를 셋팅해주시기 위해 int N에 scanner로 숫자 넣어주기
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 2중 for문이 버블정렬!
		for(int i = 0; i < N-1; i++) { 
			// 아래부터는 두 수를 비교한 값 외에 다른 값들
			for(int j = 0; j < N-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
