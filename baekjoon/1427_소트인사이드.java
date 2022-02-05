package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1427_소트인사이드 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] c = in.readLine().toCharArray();
		Arrays.sort(c);
		for (int i = c.length - 1; i >= 0; i--) {
			sb.append(c[i]);
		}
		System.out.println(sb);
	}
}
