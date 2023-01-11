package baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 나머지의합 {
	
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] sumArr = new long[N];
		long[] countArr = new long[M];
		int answer = 0;
		sumArr[0] = sc.nextInt();
		// 합배열 : S[i] = S[i-1] + A[i]
		// 1부터 받으니 위에서 sumArr[0]의 값을 초기화, 근데 어떤값이 들어오는지 잘 모르겠...
		for(int i = 1; i < N; i++) {
			sumArr[i] = sumArr[i-1] + sc.nextInt();
		}
		System.out.println(Arrays.toString(sumArr));
		// 합배열을 M으로 나눈 값으로 업데이트
		for(int i = 0; i < N; i++) {
			int update = (int)(sumArr[i] % M); // int <- long 형변환
			// 3. 업데이트한 합배열의 요소들의 값을 M으로 나눴을때, 0이면 1개의 구간이기때문에 answer++
			if(update == 0) {
				answer++;
			}
			// 4. 진짜 구간의 합 구하기
			// 나머지가 같은 인덱스 값의 수 구하기
			countArr[update]++; //countArr[0...] 에 요소값을 증가?!	
			}	
		System.out.println(countArr.length); //3	
		System.out.println(answer);//2
		
			// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
			//	S[j] % M == S[i-1] % M 을 만족하는 (i,j)의 수를 결과값에 더한다.
			for(int i = 0; i < M; i++) { // 왜 M인가요 >> 0~m-1의 값이 m의 나머지값이 될 수 있으니까..
				if(countArr[i] > 1) { //2개 이상을 뽑아와야 같은 값 사이의 합을 확인할 수 있으니까!
					answer = answer + (int)(countArr[i] * (countArr[i]-1) / 2);
				}
			}
			System.out.println(answer);
		
		
	}
}
