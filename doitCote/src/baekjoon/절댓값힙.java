package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙 {
//	절댓값이 같다 (3, -3) -> 작은 수를 출력하라 (음수 절댓값을 출력)
//  절댓값은 0과 떨어진 절대적인 거리를 뜻
//	"절대값이 작은 데이터 우선"의 의미는 0과의 거리가 가까운 데이터가 우선이라는 뜻
//	배열이 비어있을때, 출력시엔 0을 출력
//	우선순위큐 정렬기준 : 절대값의 최소값으로 정렬, 절대값이 동일할때 음수 우선 출력
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        //우선순위큐 선언
        //비교해서 pop할 예정이니, 비교할 객체 선언
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)->{
        	//정렬 기준 세우기
        	//1. 절대값이 작은 데이터 우선
        	//Math.abs() : 인자값에 대한 절대값을 반환하는 함수
        	int first_abs = Math.abs(o1);
        	int second_abs = Math.abs(o2);
        	//return에서 first_abs가 더 크면 양수리턴, second_abs가 더 크면 음수리턴
        	//2. 절대값이 동일할 때 음수 우선
        	if(first_abs == second_abs) {
        		//o1 > o2 조건식이 참이면 1, 거짓이면 -1 리턴
        		return o1 > o2 ? 1 : -1;
        	}
        	return first_abs - second_abs;
        });
        
        for(int i = 0; i < N; i++) {
        	int request = Integer.parseInt(bf.readLine());
        	if(request == 0) {
        		if(queue.isEmpty()) {
        		// 배열이 비어있을 때 0을 출력
        			System.out.println("0");
        		}else {
        			// 우선순위큐에서 끝에 있는 숫자를 하나 뽑아온다.
        			System.out.println(queue.poll());
        		}
        	}else {
        		System.out.println(queue.add(request));
        	}
        }
        
	}

}
