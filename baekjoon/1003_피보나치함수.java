package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1003_피보나치함수 {

	static int[][] f = new int[41][2];
	static boolean[] visited = new boolean[41];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		f[0][0] = f[1][1] = 1;
		f[0][1] = f[1][0] = 0;
		visited[0] = visited[1] = true;
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(in.readLine());
			int[] result = fibo(n);
			sb.append(result[0] + " " + result[1] + "\n");
		}
		System.out.println(sb);
	}

	private static int[] fibo(int n) {
		int[] answer = new int[2];
		if (n == 0 || n == 1) {
			answer[0] = f[n][0];
			answer[1] = f[n][1];
			return answer;
		} else if (!visited[n]) {
			visited[n] = true;
			int[] a = fibo(n - 1);
			int[] b = fibo(n - 2);
			f[n][0] = a[0] + b[0];
			f[n][1] = a[1] + b[1];
			answer[0] = f[n][0];
			answer[1] = f[n][1];
			return answer;
		} else {
			answer[0] = f[n][0];
			answer[1] = f[n][1];
			return answer;
		}
	}
}
