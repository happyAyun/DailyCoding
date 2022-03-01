package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11659_구간합구하기4 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(arr[b] - arr[a - 1] + "\n");
		}
		System.out.println(sb);
	}
}
