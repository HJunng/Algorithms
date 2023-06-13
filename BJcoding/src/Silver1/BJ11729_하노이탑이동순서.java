package Silver1;

import java.io.*;

public class BJ11729_하노이탑이동순서 {

	public static StringBuilder sb;
	public static void Hanoi(int N, int start, int mid, int to) {	//Hanoi(1)이면 첫번째 장대에 원판이 한개 있는것.
		if(N==1) {
			sb.append(start+" "+to+"\n");
			return;
		}
		// A -> C로 옮긴다고 가정할 떄,
		// STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
		Hanoi(N-1, start, to, mid);
		
		// STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
		sb.append(start+" "+to+"\n");
		
		// STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
		Hanoi(N-1, mid, start, to);
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); 
		
		sb.append((int) (Math.pow(2, N)-1)).append("\n");
		Hanoi(N,1,2,3);
		
		System.out.println(sb);
	}

}
