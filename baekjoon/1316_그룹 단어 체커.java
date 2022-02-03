package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1316_그룹단어체커 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int count = 0;
		boolean[] visited; // 같은 단어의 여부 체크
		for (int i = 0; i < N; i++) {
			visited = new boolean[26]; // 단어마다 새로 갱신
			String str = in.readLine();
			int j = 0; // 문자열의 각 단어 인덱스
			boolean flag = true; // 그룹단어 참 여부
			while (j < str.length()) { // 각 단어 체크 시작
				int n = str.charAt(j) - 'a';
				if (!visited[n]) { // 처음 방문된 문자
					visited[n] = true;
					while (j + 1 < str.length() && str.charAt(j + 1) - 'a' == n) { // 같은 문자열이 연속되는지 체크
						j++;
					}
				} else { // 그 전에 방문된 문자 -> 그룹 단어 거짓!
					flag = false;
					break;
				}
				j++;
			}
			if (flag)
				count++;
		}
		System.out.println(count);
	}
}
