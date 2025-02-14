import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
		int m = Integer.parseInt(br.readLine()); // 고장난 버튼 개수

		boolean[] broken = new boolean[10];
		if(m>0) {
			st = new StringTokenizer(br.readLine());

			for(int i=0;i<m;i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int result = Math.abs(n-100);

		for(int i=0;i<=999999; i++) {
			String num = String.valueOf(i);

			boolean isBreak = false;
			for(int j=0;j<num.length();j++) {
				if(broken[num.charAt(j)-'0']) {
					isBreak = true;
					break;
				}
			}
			if(!isBreak) {
				result = Math.min(result, Math.abs(n-i) + num.length());
			}
		}

		System.out.println(result);

	}
}