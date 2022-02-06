package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11403_경로찾기 { 
	// 어차피 연결을 나타내는 경로찾기이므로 모든 노드를 이용해 연결이 가능한지를 찾는 알고리즘
	// 플로이드 워셜 알고리즘을 이용해 모든 경로를 통해 노드가 연결되어 있는지만 확인하면 됨.

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N]; // 입력값이자 결과값이 될 배열
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 플로이드 워셜 알고리즘
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// k의 노드를 거쳐서 i와 j가 연결되는지를 확인
					if (arr[i][k] == 1 && arr[k][j] == 1) // i와 j도 k와도 연결이 되어있어야 함.
						arr[i][j] = 1; // 서로 연결이 가능하면 연결 여부를 표시
				}
			}
		}

		for (int i = 0; i < N; i++) { // 연결 여부 결과를 출력함.
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
				if (j != N - 1)
					sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
