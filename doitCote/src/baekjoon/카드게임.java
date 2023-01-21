package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드게임 {

	public static void main(String[] args) {
		// queue : FIFO(First-In First-Out)
		// front : 큐에서 가장 앞에 있는 데이터 영역 
		// rear : 큐에서 가장 뒤에 있는 데이터 영역
		// add : rear 부분에 새로운 데이터를 삽입하는 연산
		// poll : front 부분에 있는 데이터를 삭제하고 확인하는 연산
		// peek : front에 있는 데이터를 확인할 때 사용하는 연산
		// size : 큐 길이(크기) 확인
		
		//	*문제풀이*
		// 첫번째 카드 버리기 : poll
		// 두번째 카드 뒤로 보내기 : poll 후에 add(poll)
		// 반복 후 queue에 1개만 남았을 때, 그 값이 result
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 자바에서 큐는 LinkedList로 구현한 큐가 가장 대중적
		// 연결리스트 : 각 데이터들을 노드(node)객체에 담고 노드 간 서로 연결해준다.
		// 삽입, 삭제는 연결 된 링크만 끊어주거나 이어주면 되기에 관리하기 편하다.
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) { //카드 조건이 1부터!
			queue.add(i); // 카드를 큐에 저장
		}
		
		while(queue.size() > 1) {
			// 첫번째 카드 버리기
			queue.poll();
			// 두번째 카드 뒤로 보내기
			queue.add(queue.poll());
		}
		//마지막으로 남은 카드 확인
		System.out.println(queue.peek());
	}

}
