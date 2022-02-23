package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_5430_AC {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			String order = in.readLine(); // 명령
			int N = Integer.parseInt(in.readLine());
			String str = in.readLine();
			str = str.substring(1, str.length() - 1); // [] 없애기
			StringTokenizer st = new StringTokenizer(str, ",");
			Deque<Integer> d = new LinkedList<>();
			while (st.hasMoreElements()) {
				d.addLast(Integer.parseInt(st.nextToken()));
			}

			boolean isError = false;
			boolean front = true; // R에 따른 포커스 방향
			for (int j = 0; j < order.length(); j++) {
				if (d.size() == 0 && order.charAt(j) == 'D') { // 아래에 놓으면 안되고 무조건 위에 놓아야 함. -> 아래에 놓으면 연산 후 0이 되면 error를
																// 출력하는 이슈 발생
					// 또한 d의 사이즈가 0이어도 R의 명령어일 경우 처리가 가능하므로 error가 아니다!! ***
					sb.append("error\n");
					isError = true;
					break;
				}
				if (order.charAt(j) == 'R') {
					front = !front;
				} else { // D
					if (front)
						d.pollFirst();
					else
						d.pollLast();
				}
			}

			if (!isError) {
				StringBuilder result = new StringBuilder();
				if (front) {
					while (d.size() > 0) {
						result.append(d.pollFirst() + ",");
					}
					if (result.length() == 0) // ** result의 길이가 0인 경우!!! 체크 -> 결과값이 []이고, error가 아님.
						sb.append("[]\n");
					else
						sb.append("[" + result.substring(0, result.length() - 1) + "]" + "\n");
				} else {
					while (d.size() > 0) {
						result.append(d.pollLast() + ",");
					}
					if (result.length() == 0) // ** result의 길이가 0인 경우!!! 체크 -> 결과값이 []이고, error가 아님.
						sb.append("[]\n");
					else
						sb.append("[" + result.substring(0, result.length() - 1) + "]" + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
