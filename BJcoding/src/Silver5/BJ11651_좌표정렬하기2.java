package Silver5;

import java.io.*;
import java.util.Arrays;

public class BJ11651_좌표정렬하기2 {	//7min.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String []str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int arr[][] = new int[N][2];
		
		for(int i=0;i<N;i++) {
			str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(arr, (a,b) -> {
			if(a[1]==b[1]) {	//y좌표가 같으면
				return a[0]-b[0];
			}else {
				return a[1]-b[1];
			}
		});
		for(int i=0;i<N;i++)
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		System.out.println(sb);
	}

}
