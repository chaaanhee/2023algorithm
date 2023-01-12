package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 주몽의명령 {

	public static void main(String[] args) {

		//A[start] + A[end] > M 면 end--;
		//A[start] + A[end] < M 면 start++;
		//A[start] + A[end] == M 면 start++; end--; count++;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 재료의 갯수
		int M = sc.nextInt(); // 갑옷이 완성되는 번호의 합
		
		// A배열의 갯수는 재료의 갯수와 동일
		int[] A = new int[N];
		// A배열의 값 추가
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		// 최소값, 최대값을 구하기 위해 정렬
		Arrays.sort(A);
		
		int count = 0;
		int start = 0;
		int end = N-1; // 배열이라 끝 인덱스 번호
		
		while(start < end) {
			// 최소값부터 움직여야한다. 
			if(A[start] + A[end] < M) {
				start++;
			}else if(A[start] + A[end] > M) {
				end--; // 최댓값보다 하나 적은 최댓값으로!
			}else {
				count++;
				//한번 사용한 인덱스는 사용하지 않아야 함으로 start++, end--로 조여야한다!
				start++;
				end--;
			}
		}
				
		System.out.println(count);
		
	}

}
