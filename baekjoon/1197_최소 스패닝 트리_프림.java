package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1197_최소스패닝트리 { // 프림

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Node>[] list = new ArrayList[V]; // list - 노드 수 만큼
		for (int i = 0; i < V; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			list[A].add(new Node(B, C));
			list[B].add(new Node(A, C)); // ** 방향이 없는 연결
		}

		int result = 0;
		int cnt = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V];
		pq.offer(new Node(0, 0)); // 시작 - 방문처리 X
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visited[now.end])
				continue;
			visited[now.end] = true;
			result += now.weight;
			if (++cnt == V) // 노드의 수
				break;
			for (Node next : list[now.end]) {
				if (visited[next.end])
					continue;
				pq.offer(next);
			}
		}
		System.out.println(result);
	}

	static class Node implements Comparable<Node> {
		int end, weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}
}
