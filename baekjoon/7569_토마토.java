package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7569_토마토 {

	static int[][] dir = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 0, 1, 0 }, { 0, -1, 0 } }; // 상 하 좌

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] arr = new int[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];
		Queue<Node> q = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1) {
						q.offer(new Node(i, j, k, 0));
						visited[i][j][k] = true;
					} else if (arr[i][j][k] == 0)
						count++;
				}
			}
		}
		if (count == 0) {
			System.out.println(0);
			return;
		}

		int result = -1;
		while (!q.isEmpty()) {
			Node now = q.poll();
			int h = now.h;
			int y = now.y;
			int x = now.x;
			int time = now.time;
			for (int i = 0; i < 6; i++) {
				int mh = h + dir[i][0];
				int my = y + dir[i][1];
				int mx = x + dir[i][2];
				if (mh < 0 || my < 0 || mx < 0 || mh >= H || my >= N || mx >= M)
					continue;
				if (visited[mh][my][mx] || arr[mh][my][mx] == -1)
					continue;
				visited[mh][my][mx] = true;
				if (--count == 0) {
					result = time + 1;
					break;
				}
				arr[mh][my][mx] = 1;
				q.offer(new Node(mh, my, mx, time + 1));
			}
		}
		System.out.println(result);
	}

	static class Node {
		int h, y, x, time;

		public Node(int h, int y, int x, int time) {
			super();
			this.h = h;
			this.y = y;
			this.x = x;
			this.time = time;
		}

	}
}
