package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_14916_거스름돈 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int five = N / 5; // 5원의 개수
		while ((N - (five * 5)) % 2 != 0) { // 2원을 위해 나머지를 짝수를 만든다
			if (--five <= 0) { // five가 -1이 되면 아래의 연산에 영향을 주므로 0으로 
				five = 0;
				break;
			}
		}
		int two = 0; // 2원의 개수
		if ((N - (five * 5)) % 2 == 0) { // 2원으로 나누어 떨어지면 거스름돈 OK
			two = (N - (five * 5)) / 2;
			System.out.println(five + two);
		} else // 그렇지 않으면 -1
			System.out.println(-1);
	}
}
