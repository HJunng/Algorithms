package Gold5;

import java.io.*;
public class BJ25682_체스판다시칠하기2 {	//120m.
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int n=Integer.parseInt(str[0]);
		int m= Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		
		int arr[][] = new int[n+1][m+1];	//행 누적합
		int sum[][] = new int[n+1][m+1];	//전체 누적합
		for(int i=1;i<=n;i++) {//nm 누적합 구하기
			str = br.readLine().split("");
			for(int j=1;j<=m;j++) {
				if((i+j)%2==0 && str[j-1].equals("B")) { //B가 올 자리에 B가 오면
					arr[i][j] = arr[i][j-1]; //색칠할 필요 없어서 행 누적값만 저장.
				}else if((i+j)%2==1 && str[j-1].equals("W")) { //W 올 자리에 W 오면
					arr[i][j] = arr[i][j-1];
				}else { //색칠을 해야할 경우. ( B 올 자리에 W, W 올 자리에 B) 
					arr[i][j] = arr[i][j-1] +1;
				}
				sum[i][j] = sum[i-1][j] + arr[i][j];	//전체 누적합.
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=k;i<=n;i++) {
			for(int j=k;j<=m;j++) {
				int startBlack = sum[i][j]-sum[i-k][j] - sum[i][j-k] + sum[i-k][j-k];
				if(startBlack < min) min = startBlack;
				
				int startWhite = k*k - startBlack;
				if(startWhite<min) min = startWhite;
			}
		}
		System.out.println(min);
	}

}
