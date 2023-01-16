package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 좋은수구하기 {

	public static void main(String[] args) {
		
//		A[i]+A[j] > K 는 j--; : end점이 작아진다는 것은 A[i]+A[j]가 작아진다.
//		A[i]+A[j] < K 는 i++; : start점이 커진다는 것은 A[i]+A[j]가 커진다.
//		A[i]+A[j] == K는 i++; j--; count++; : count값이 정답, 투포인터 이동, 프로세스 종료
//	 	투포인터의 기본조건 : i < j
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[] = new int[N];
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		// 투포인터 사용시엔 대부분 정렬을 해야할 듯!
		// 최댓값과 최솟값을 사용하기 위해
		Arrays.sort(a);
		
		for(int k = 0; k < N; k++) {
			//찾아야 할 값 = a[k]
			int find = a[k];
			int i = 0; // 최소값
			int j = N-1; // 최대값
			
			//알고리즘 만들기
			while(i < j) {
				if(a[i]+a[j] == find) {
					//예외처리 (k가 자기자신이면 안된다.)
					//범위가 정수이기 때문에 0도 들어올 수 있다.
					//예) 0+5 일때, 5는 좋은 수가 아니다.
					if(i != k && j != k) {
						answer++;
						break;
					}else if(i == k) {
						// (start값을 올려준다)
						i++;
					}else if(j == k) {
						j--;
					}
				} else if(a[i]+a[j] < find) {
					//A[i]+A[j]가 증가
					i++;
				} else if(a[i]+a[j] > find) {
					//A[i]+A[j]가 감소
					j--;
				}
			}
		}
		System.out.println(answer);
	}

}
