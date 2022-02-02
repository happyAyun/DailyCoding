package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1647_도시분할계획 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] list = new Node[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			list[i] = new Node(A, B, C);
		}
		int[] parents = new int[N];
		make(N, parents);
		Arrays.sort(list);
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < M; i++) {
			if (union(list[i].start, list[i].end, parents)) {
				if (++cnt == N - 1)
					break;
				result += list[i].weight; // 맨 마지막 연결을 제외하기 위해 if문 다음에 위치
			}
		}
		System.out.println(result);
	}

	private static void make(int N, int[] parents) {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a, int[] parents) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a], parents);
	}

	private static boolean union(int a, int b, int[] parents) {
		int aRoot = find(a, parents);
		int bRoot = find(b, parents);
		if (aRoot == bRoot)
			return false;
		parents[aRoot] = bRoot;
		return true;
	}

	static class Node implements Comparable<Node> {
		int start, end, weight;

		public Node(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}
