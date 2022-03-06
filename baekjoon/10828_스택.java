package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_10828_스택 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			String str = st.nextToken();
			if (str.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			} else if (str.equals("top")) {
				if (stack.isEmpty())
					sb.append(-1 + "\n");
				else
					sb.append(stack.peek() + "\n");
			} else if (str.equals("size")) {
				sb.append(stack.size() + "\n");
			} else if (str.equals("empty")) {
				if (stack.isEmpty())
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			} else if (str.equals("pop")) {
				if (stack.isEmpty())
					sb.append(-1 + "\n");
				else
					sb.append(stack.pop() + "\n");
			}
		}
		System.out.println(sb);
	}
}
