import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 현재까지 만들어진 리프의 개수
		int curLeaf = 0;

		// 필요한 리프가 2개인 경우, 0번 노드도 리프 취급
		if (m==2) curLeaf = 1;

		// 가장 최근에 붙인 노드의 번호
		int lastLeaf = 0;

		// 그래프 만들기
		for (int i=1; i<n; i++) { // N개 노드를 다 붙일 때까지
			// m개의 리프가 만들어지기 전인 경우
			if (m > curLeaf) {
				// 리프 하나 추가
				sb.append(0+" "+i+"\n");
				curLeaf++;
			}

			// 이미 m개 리프가 다 만들어진 이후인 경우
			// 마지막에 붙인 노드에 줄줄이 이어붙이기
			else {
				sb.append(lastLeaf+" "+i+"\n");
			}

			// 마지막에 붙인 노드 번호 갱신
			lastLeaf = i;
		}
		System.out.println(sb);
	}
}