package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		//[경축] 첫 stack 사용!
		Stack<Integer> stack = new Stack<>();
		StringBuffer bf = new StringBuffer();
		
		int num = 1;
		boolean result = true; 
		
		for(int i = 0; i < A.length; i++) {
			//num과 su를 비교하여 결과값 도출
			int su = A[i];
			if(num <= su) { // 값이 작으면 pop이 되지않음으로 
				while(num <= su) {
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			}
			else { //(num > su)
				// n이 제일 위에 있는 수
				// stack.pop()으로 빠지는 수는 항상 맨 위에 있는 값
				int n = stack.pop(); 
				if(n > su) { // 이 경우는 아예 식이 이뤄지지않음.
					System.out.println("NO");
					result = false; // 아래 bf.toString이 출력되지 않도록 false값으로 변경
					break; // 브레이크는 반복문을 빠져나가는 문, if문이 아니라 for문을 나감
				}else {  // pop으로 맨 위에 숫자를 뺐으니  "-" 표시
					bf.append("-\n");
				}
			}
		}if(result) {
			System.out.println(bf.toString());
		}
		
	}

}
