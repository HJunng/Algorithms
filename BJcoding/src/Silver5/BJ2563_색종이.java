package Silver5;

import java.io.*;

public class BJ2563_색종이 {	//15min

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int result=0;
		int T = Integer.parseInt(str[0]);
		boolean a[][] = new boolean[101][101];	//모든 값 false로 초기화.
		for(int k=0;k<T;k++) {
			result+=100;
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			
			for(int i=x+1;i<=x+10;i++) {
				for(int j=y+1;j<=y+10;j++) {
					if(!a[i][j]) a[i][j]=true;
					else result--;
				}
			}
		}
		System.out.println(result);
	}
}
