package Silver2;

import java.io.*;
public class BJ2630_색종이만들기 { // 30min. 답.
	static int arr[][]; // 주어진 색 배열
	static int white=0; // 하얀색 색종이 개수
	static int blue=0; // 파란색 색종이 개수

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		String[] str;
		for(int i=0;i<N;i++) {
			str = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		partition(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	/* 해당 면적이 같은 색인지 확인, 그렇지 않으면 4분할 */
	public static void partition(int startX, int startY, int size) {
		
		if(checkAllSame(startX, startY, size)) {
			if(arr[startX][startY]==0)
				white++;
			else
				blue++;
			//다 같은 색이면 종료.
			return;
		}
		
		size /= 2; // 색이 다르면 4분할.
		
		//재귀호출
		partition(startX,startY,size); // 1번
		partition(startX, startY+size,size); // 2번
		partition(startX+size,startY,size); // 3번
		partition(startX+size,startY+size,size); // 4번
	}
	/* 같은 색인지 확인하는 함수 */
	public static boolean checkAllSame(int startX, int startY, int size) {
		
		boolean result=true;
		int color = arr[startX][startY];
		for(int i=startX;i<startX+size;i++) {
			//색이 같지 않으면 break;
			if(!result)
				break;
			for(int j=startY;j<startY+size;j++) {
				//색이 같은지 확인해서 같지 않으면 boolean값 false로 바꾸기
				if(arr[i][j] != color) {
					result=false;
					break;
				}
			}
		}
		return result;
	}
}