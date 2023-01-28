package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑 {
//재귀함수 : 자기 자신을 호출하는 함수, 종료 조건이 충족될 때 까지 반복적으로 스스로를 불러내며 주어진 작업을 수행하는 것
//꼬리재귀 : return값이 함수 자기 자신

	//멀티쓰레드 환경에선 StringBuffer가 더 적합하지만,
	//동기화를 고려하지 않을 땐, 단일쓰레드 환경에선 StringBuilder가 더 성능이 뛰어나다.
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("원판의 갯수를 입력하세요.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N은 원판의 갯수
		int N = Integer.parseInt(br.readLine());
						//제곱함수(2,N)-1을 해줍니다.
		sb.append((int)(Math.pow(2, N) - 1)).append('\n');
		
		Hanoi(N, 1, 2, 3);
		System.out.println(sb);
		
		
	}
	// 원판갯수, 출발지기둥, 목적지기둥, 나머지기둥
	public static void Hanoi(int N, int start, int dest, int rem) {
		//이동할 원판의 수가 1개라면 아래 if문으로
		if(N == 1) {
			sb.append(start + " " + rem + "\n");
			return;
		}
		// A -> C 로 옮긴다.
		//1. N-1개를 A에서B로 이동(== start에서 N-1개의 원판을 dest로 이동)
		Hanoi(N-1, start, rem, dest);
		//2. 1개를 A에서 C로 이동(== start에서 N번째 원판을 rem으로 이동)
		sb.append(start + " " + rem + "\n");
		//3.N-1개를 B에서 C로 이동(== dest에서 N-1개의 원판을 rem으로 이동)
		Hanoi(N-1, dest, start, rem);
	}
	

}
