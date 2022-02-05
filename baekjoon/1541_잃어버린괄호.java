package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), "-");
		int result = 0;
		boolean flag = false; // 첫번째 -가 나오기 전에는 무조건 +이므로 처음 +임을 알려주는 용도
		while (st.hasMoreTokens()) { // '-' 묶음
			StringTokenizer str = new StringTokenizer(st.nextToken(), "+");
			int sum = 0;
			while (str.hasMoreTokens()) {
				sum += Integer.parseInt(str.nextToken());
			}
			if (!flag) { // 맨 처음
				result += sum;
				flag = true;
			} else {
				result -= sum; // 맨 처음을 제외한 모든 수는 -
			}
		}
		System.out.println(result);
	}
}
