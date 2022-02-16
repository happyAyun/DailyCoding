package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class B_2800_괄호제거 {

	static List<Integer> list;
	static List<String> result;
	static Set<String> set = new TreeSet<>(); // 결과 - 중복 X, 정렬O

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = in.readLine();
		Stack<Integer> stack = new Stack<>(); // 여는 괄호 인덱스
		List<Node> list = new ArrayList<>(); // 괄호쌍 인덱스
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else if (c == ')') {
				int idx = stack.pop();
				list.add(new Node(idx, i));
			}
		}
		boolean[] visited = new boolean[list.size()];
		subset(0, list, visited, str);
		for (String s : set) { // iterator 필요없이 for-each로 가능함.!!
			sb.append(s + "\n");
		}
		System.out.println(sb);
	}

	private static void subset(int cnt, List<Node> list, boolean[] visited, String str) {
		if (cnt == list.size()) {
			StringBuilder sb = new StringBuilder();
			boolean[] checked = new boolean[str.length()];
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == true) {
					checked[list.get(i).a] = true;
					checked[list.get(i).b] = true;
				}
			}
			for (int i = 0; i < str.length(); i++) {
				if (checked[i])
					continue;
				sb.append(str.charAt(i));
			}
			if (sb.length() != str.length()) // 같으면 괄호가 다 있는 경우 - 부분집합의 공집합인 경우 제외
				set.add(sb.toString());
			return;
		}
		visited[cnt] = true;
		subset(cnt + 1, list, visited, str);
		visited[cnt] = false;
		subset(cnt + 1, list, visited, str);
	}

	static class Node {
		int a, b; // open, close

		public Node(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

	}

}
