package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2638_치즈 { 

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int cheeseCnt = 0; // 시작 치즈의 개수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					cheeseCnt++;
				}
			}
		}
		int startY = 0; // 첫 시작 지점 - 0인 곳
		int startX = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					startY = i;
					startX = j;
					break;
				}
			}
		}
		int result = bfs(cheeseCnt, startY, startX, N, M, arr);
		System.out.println(result);
	}

	private static int bfs(int cheeseCnt, int startY, int startX, int N, int M, int[][] arr) {
		int time = 0; // 결과값
		while (cheeseCnt > 0) { // 치즈가 모두 녹아없어질 때까지
			time++; // 시간 경과
			
			for (int i = 0; i < N; i++) { // 2번 이상의 실내 접촉 - 1로 줄어든 치즈 다시 원상 복귀
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1) {
						arr[i][j] = 2;
					}
				}
			}
			int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
			Queue<Node> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			visited[startY][startX] = true;
			q.offer(new Node(startY, startX));
			
			while (!q.isEmpty()) {
				Node now = q.poll();
				int y = now.y;
				int x = now.x;
				for (int i = 0; i < 4; i++) {
					int my = y + dir[i][0];
					int mx = x + dir[i][1];
					if (my < 0 || mx < 0 || my >= N || mx >= M || visited[my][mx])
						continue;
					if (arr[my][mx] == 0) { // 치즈가 없으면 큐에 넣기
						visited[my][mx] = true;
						q.offer(new Node(my, mx));
					} else {// 녹아내림
						arr[my][mx]--;
						if (arr[my][mx] == 0) { // 다 녹아내리면 방문처리 - 2번 모두를 방문해야하므로 1번째에는 방문처리를 하지 않음.
							cheeseCnt--;
							visited[my][mx] = true;
						}
					}
				}
			}
		}
		return time;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
