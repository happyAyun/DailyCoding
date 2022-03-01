package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2167_2차원배열의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
			}
		}
		int K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append((arr[x][y] - arr[a - 1][y] - arr[x][b - 1] + arr[a - 1][b - 1]) + "\n"); // 여기
		}
		System.out.println(sb);
	}
}
