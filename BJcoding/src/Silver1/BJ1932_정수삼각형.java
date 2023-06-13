package Silver1;

import java.io.*;
public class BJ1932_정수삼각형 {	//17min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int [n+1][n+1];
		//아래층에 있는 수는 현재 층에서 대각선 왼쪽이나 오른쪽을 선택하는데 맨 앞의 수는 outOfBounds 나올까봐 n+1로 배열 선언.
		
		arr[1][1] = Integer.parseInt(br.readLine());
		for(int i=2;i<=n;i++) {
			String str[] = br.readLine().split(" ");
			for(int j=1;j<=i;j++) {
				int max = Math.max(arr[i-1][j-1], arr[i-1][j]); //대각선 왼쪽, 오른쪽 더 큰 수 더해서 자리에 넣음.
				arr[i][j] = Integer.parseInt(str[j-1])+max;
			}
		}
		int max = arr[n][1];
		for(int i=2;i<=n;i++)
			if(arr[n][i]>max) max = arr[n][i];
		System.out.println(max);
	}
}