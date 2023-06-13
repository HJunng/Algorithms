package D3;

import java.io.*;

public class SWEA1206_View {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=10;t++) {
			int cnt=0;
			
			int N = Integer.parseInt(br.readLine());
			int[][] check = new int[N][3]; //0:높이, 1:왼쪽 조망 확인, 2:오른쪽 조망 확인
			
			String[] s = br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				check[i][0] = Integer.parseInt(s[i]);
				
				//조망 확인 가능한 높이이면 왼쪽 조망 확인
				if(check[i][0]!=0) {
					//i-1,i-2 높이가 현재 건물보다 낮을 때 검사함.
					if(check[i][0]>check[i-1][0] && check[i][0]>check[i-2][0]) {
						check[i][1] = Math.min(check[i][0]-check[i-1][0], check[i][0]-check[i-2][0]);
					}
				}
			}
			//오른쪽 조망 확인
			for(int i=0;i<N;i++) {
				//건물 높이가 0이 아니고, 왼쪽 조망이 확보된 건물만 검사 
				if(check[i][0]!=0 && check[i][1]>0) {
					if(check[i][0]>check[i+1][0] && check[i][0]>check[i+2][0]) {
						check[i][2] = Math.min(check[i][0]-check[i+1][0], check[i][0]-check[i+2][0]);
						
						//조망권이 확보된 칸 세기
						cnt+=Math.min(check[i][1], check[i][2]);
					}
				}
			}
			sb.append("#"+t+" "+cnt+"\n");
		}
		System.out.println(sb);
	}

}
