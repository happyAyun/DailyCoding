package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_7568_덩치 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		List<Node> list = new ArrayList<>();
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Node(x, y));
		}
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (list.get(i).x < list.get(j).x && list.get(i).y < list.get(j).y)
					cnt++;
			}
			result[i] = cnt;
		}
		for (int i = 0; i < N; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb.substring(0, sb.length() - 1));
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
