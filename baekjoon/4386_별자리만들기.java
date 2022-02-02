package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_4386_별자리만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Node[] star = new Node[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			double fy = Float.parseFloat(st.nextToken());
			double fx = Float.parseFloat(st.nextToken());
			star[i] = new Node(fy, fx);
		}

		int cnt = 0;
		double result = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		pq.offer(new Edge(0, 0)); // 시작
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (visited[now.end])
				continue;
			visited[now.end] = true;
			result += now.weight;
			if (++cnt == N)
				break;
			for (int i = 0; i < N; i++) {
				if (visited[i] || now.end == i)
					continue;
				double dist = Math
						.sqrt(Math.pow(star[i].x - star[now.end].x, 2) + Math.pow(star[i].y - star[now.end].y, 2));
				pq.offer(new Edge(i, dist));
			}
		}
		System.out.println(String.format("%.2f", result));
//		System.out.println(result); - 이렇게 해도 통과
	}

	static class Edge implements Comparable<Edge> {
		int end;
		double weight;

		public Edge(int end, double weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}

	}

	static class Node {
		double y, x;

		public Node(double y, double x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
