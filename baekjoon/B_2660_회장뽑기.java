package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2660_회장뽑기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int INF = 987654321;
		int N = Integer.parseInt(in.readLine());
		int[][] friendly = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				friendly[i][j] = INF;
			}
		}

		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1)
				break;

			friendly[a - 1][b - 1] = 1;
			friendly[b - 1][a - 1] = 1;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (friendly[i][k] + friendly[k][j] < friendly[i][j])
						friendly[i][j] = friendly[i][k] + friendly[k][j];
				}
			}
		}

		int[] result = new int[N];
		int min = INF;

		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < N; j++) {
				max = Math.max(max, friendly[i][j]);
			}
			result[i] = max;
			min = Math.min(min, result[i]);
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (min == result[i]) {
				cnt++;
				sb.append((i + 1) + " ");
			}
		}

		System.out.println(min + " " + cnt);
		System.out.println(sb.substring(0, sb.length() - 1));
	}

}
