package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_9663_NQueen {

	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] board = new int[N]; // 퀸의 위치 - 행은 index(무조건 한 행에 한개의 퀸이 위치해야 하므로), 열이 배열의 값
		solve(0, N, board);
		System.out.println(result);
	}

	private static boolean isPossible(int cnt, int x, int[] board) {
		for (int i = 0; i < cnt; i++) {
			// 같은 행은 비교할 필요가 없고, 열에 존재하거나 대각선 상에 존재할 경우
			if (x == board[i] || Math.abs(cnt - i) == Math.abs(x - board[i]))
				return false;
		}
		return true;
	}

	private static void solve(int cnt, int N, int[] board) {
		if (cnt == N) {
			result++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isPossible(cnt, i, board)) {
				board[cnt] = i;
				solve(cnt + 1, N, board);
			}
		}
	}

}
