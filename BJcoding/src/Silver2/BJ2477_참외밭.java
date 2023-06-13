package Silver2;

import java.io.*;

public class BJ2477_참외밭 {		//75min. 답 참고.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		//참외밭은 무조건 육각형
		String str[];
		int A[][] = new int[6][2];
		int w=0;//가장 긴변.
		int h=0;
		int maxXIndex=0;//가장 긴변의 index.
		int maxYIndex=0;
		for(int i=0;i<6;i++) {
			str = br.readLine().split(" ");
			A[i][0] = Integer.parseInt(str[0]);
			A[i][1] = Integer.parseInt(str[1]);
			if(A[i][0]==1 || A[i][0]==2){//동쪽이나 서쪽이면
				if(A[i][1]>w) {	//가장 긴 가로변 구함.
					w = A[i][1];
					maxXIndex=i;	//가장 긴 가로변의 인덱스 저장.
				}
			}else {//북쪽이나 남쪽으로 이동할 때.
				if(A[i][1]>h) {
					h = A[i][1];
					maxYIndex=i;	//가장 긴 세로변의 인덱스 저장.
				}
			}
		}
		int result = w * h;	//가장 큰 사각형에서 빈 사각형 빼기.
		result -= A[(maxXIndex+3)%6][1] * A[(maxYIndex+3)%6][1];
		//가장 긴변의 가로 +3번째가 빼야하는 가로. 가장 긴 세로변의 +3번째가 빼야하는 세로길이.
		
		System.out.println(result*K);
	}
}