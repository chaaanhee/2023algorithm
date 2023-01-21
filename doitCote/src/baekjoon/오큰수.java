package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 오큰수 {
	// 오근주 구하기💚
	public static void main(String[] args) throws IOException {
		//InputStreamReader로 수를 받는데, InputStreamReader은 매개변수를 반드시 갖고 있어야 함으로 system.in으로 갖는다.
		//InputStreamReader는 크기를 지정해줘야 하는데, 매번 지정해 줄 수 없으니
		//Buffered로 받기위해 Buffered의 매개변수로 넣는다.
		//BufferedReader는 문자 입력 스트림에서 텍스트를 읽고 문자를 버퍼링하여 효율적인 읽기를 제공
		//즉, 입력받기 위한 생성자 생성
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// readLine() 은 스트림으로부터 한 줄을 읽어 문자열을 리턴해주는 메소드
		// readLine() 은 IOException 예외처리를 해줘야 한다.
		// 즉, 입력받은 String객체를 Integer로 변환
		int n = Integer.parseInt(bf.readLine());
		// a[]은 수열 배열 생성
		// ans[]은 정답 배열 생성
		int[] a = new int[n];
		int[] ans = new int[n];
		
		// 연속된 문자열일 경우, String 배열에 하나씩 입력한다.
		String[] str = bf.readLine().split(" ");
		// a배열에 넣기 
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		// for문으로 돌리면 너무 오래걸림
		// Stack 생성
		Stack<Integer> stack = new Stack<>();
		//stack을 생성할때, 처음에 항상 빈 상태이기 때문에 인덱스0을 넣어준다.
		//값을 넣어주는 것이 아니라 인덱스를 넣어주는 것!
		stack.push(0);
		
		for(int i = 0; i < n; i++) {
			// stack.peek을 통해 맨 위에 있는 값을 확인하고, 
			// 들어오려는 값보다 맨 윗 값이 더 커야 while문으로 들어가게끔 한다.
			while(!stack.isEmpty() && a[stack.peek()] > a[i]) {
			//a[i]:비교할 값
			ans[stack.pop()] = a[i];	
			}
			stack.push(i); //새로운 데이터 push
		}
		
		// 오른쪽에 큰 수가 없다면, 스택 안에 남아있는 인덱스에 -1을 넣기
		// stack이 비어있지 않다면, 데이터를 다 소비할때까지 while문 돌리기
		while(!stack.empty()) {
			ans[stack.pop()] = -1;
			//스택에 쌓인 인덱스에 -1을 넣기
		}
		// 배열의 값이 엄청 클 때, BufferedWriter를 사용하는 것이 시간의 복잡도를 줄일 수 있다.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < n; i++) {
			bw.write(ans[i]+ " ");
		}
		bw.write("\n"); // 남아있는 모든 값을 출력시킴
		bw.flush(); // 스트림 클로즈
	}
}
