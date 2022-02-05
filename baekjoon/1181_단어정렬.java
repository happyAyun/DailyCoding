package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B_1181_단어정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = in.readLine();
		}
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) { // 문자열의 사전 순
					return o1.compareTo(o2);
				}
				return Integer.compare(o1.length(), o2.length()); // ** 길이는 숫자이므로 Integer.compare()을 통한 숫자 비교 사전순!!!!!!!
			}
		});
		String before = "";
		for (int i = 0; i < N; i++) {
			if (str[i].equals(before)) // 같은 단어 pass
				continue;
			before = str[i]; // 단어 갱신
			sb.append(before + "\n");
		}
		System.out.println(sb);
	}
}
