package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1316_그룹단어체커 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int count = 0;
		boolean[] visited;
		for (int i = 0; i < N; i++) {
			visited = new boolean[26];
			String str = in.readLine();
			int j = 0;
			boolean flag = true;
			while (j < str.length()) {
				int n = str.charAt(j) - 'a';
				if (!visited[n]) {
					visited[n] = true;
					while (j + 1 < str.length() && str.charAt(j + 1) - 'a' == n) {
						j++;
					}
				} else {
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
