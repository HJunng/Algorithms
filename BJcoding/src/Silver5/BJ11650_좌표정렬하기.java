package Silver5;

import java.io.*;
import java.util.*;

public class BJ11650_좌표정렬하기 {		//30min. 답 봄.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int arr[][] = new int[N][2];
		
		for(int i=0;i<N;i++) {
			str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);	//x좌표
			arr[i][1] = Integer.parseInt(str[1]);	//y좌표
		}
		
		Arrays.sort(arr, (a,b)->{
			if(a[0]==b[0]) {	//x좌표가 같다면
				return a[1]-b[1];		//y 좌표 비교.
										//앞의 수의 y좌표가 더 크다면 양수 리턴.
			}else {	//x좌표가 다를 때
				return a[0]-b[0];		//앞의 수의 x좌표가 더 크면 양수 리턴.
			}
		});
		for(int i=0;i<N;i++)
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		System.out.println(sb);
	}

}
