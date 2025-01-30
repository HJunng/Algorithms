import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int[][] video;
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 0 1 값 입력
		video = new int[N][N];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				video[i][j] = s.charAt(j) - '0';
			}
		}

		sb = new StringBuilder();

		// 처음에는 모든 색깔이 같은지 확인 1번 하기.
		if(isAllSameColor(0,0,N)) {
			sb.append(video[0][0]);
		} else { // 아니면 QuadTree 재귀함수 넘어가기.
			QuadTree(0,0,N);
		}

		// 출력하기.
		System.out.println(sb);

	}
	private static void QuadTree(int startX, int startY, int length) {
		// 1. "(" 추가
		sb.append("(");

		// 2. 4 구역으로 쪼개기.
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {

				// 쪼갠 구역의 시작점
				int splitStartX = startX + i*(length/2);
				int splitStartY = startY + j*(length/2);
				// 쪼갠 구역의 길이
				int splitLength = length/2;


				// 3. 한 구역이 모두 같은 색이면, 그 색깔 출력.
				if(isAllSameColor(splitStartX, splitStartY, splitLength)) {
					sb.append(video[splitStartX][splitStartY]);
				}
				// 4. 한 구역이 다른 이 하나라도 있으면, 재귀함수 호출.
				else {
					QuadTree(splitStartX, splitStartY, splitLength);
				}
			}
		}

		// 5. 괄호 닫기
		sb.append(")");
	}
	private static boolean isAllSameColor(int startX, int startY, int length) {
		for(int i=startX;i<startX+length;i++) {
			for(int j=startY;j<startY+length;j++) {

				// 하나라도 다른 색깔이 있으면 false 반환.
				if(video[i][j]!=video[startX][startY]){
					return false;
				}
			}
		}
		return true;
	}
}