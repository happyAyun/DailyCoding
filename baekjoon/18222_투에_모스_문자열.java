package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_18222_투에모스문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long K = Long.parseLong(in.readLine());
		System.out.println(mos(K - 1));
	}

	private static int mos(long N) {
		if (N == 0)
			return 0;
		else if (N == 1)
			return 1;
		else if (N % 2 == 0)
			return mos(N / 2);
		else
			return 1 - mos(N / 2);
	}
}
