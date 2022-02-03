package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_10773_제로 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>(); // 뒤 숫자부터 제거하기 위해 스택 사용
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(in.readLine());
			if (n != 0) { // 0 이 아니면 push
				stack.push(n);
			} else // 0 이면 pop
				stack.pop();
		}
		long result = 0; // long
		while (!stack.isEmpty()) { // 스택에 존재하는 수를 더한다.
			result += stack.pop();
		}
		System.out.println(result);
	}
}
