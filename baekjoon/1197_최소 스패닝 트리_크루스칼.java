package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1197_최소스패닝트리 { // 크루스칼

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Node[] list = new Node[E]; // 배열 - 간선만큼

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			list[i] = new Node(A, B, C);
		}
		int[] parents = new int[V];

		make(V, parents);
		Arrays.sort(list);

		int cnt = 0;
		int result = 0;
		for (Node e : list) {
			if (union(e.start, e.end, parents)) {
				result += e.weight;
				if (++cnt == V - 1) // 간선 연결의 수
					break;
			}
		}
		System.out.println(result);
	}

	private static void make(int V, int[] parents) {
		for (int i = 0; i < V; i++) {
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
		parents[bRoot] = aRoot;
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
