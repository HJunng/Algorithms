package Gold4;

import java.io.*;

public class BJ2580_스도쿠_답 {	//50min. 답.
	public static int arr[][] = new int [9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[];
		for(int i=0;i<9;i++) {//입력값 받아오기
			str=br.readLine().split(" ");
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(str[j]);
			}
		}
		dfs(0,0);
	}
	private static void dfs(int row, int col) {
		
		if(col == 9) {	//열을 끝까지 다 비교했으면 다음 행으로 넘어감.
			dfs(row+1,0);
			return;
		}
		
		if(row == 9) {	//행, 열을 모두 다 입력했으면 출력.
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);//여기서 출력하고.
			
			System.exit(0);//시스템 종료.
		}
		
		if(arr[row][col]==0) {//빈 칸이면 실행.
			for(int i = 1 ; i <= 9 ; i++) {
				if(check(row, col, i)) {//i값이 들어갈 수 있는지 확인.
					arr[row][col] = i;
					dfs(row, col+1);
				}
			}
			arr[row][col]=0;
			return;
		}
		
		dfs(row, col+1);	//다음 행 탐색.
	}

	private static boolean check(int row, int col, int val) {
				//같은열에 val값이 존재하면 return;
				for(int i = 0 ; i < 9 ; i ++) {
					if(arr[row][i] == val) {
						return false;
					}
				}
				
				//같은행에 val값이 존재하면 return;
				for(int i = 0 ; i < 9 ; i ++) {
					if(arr[i][col] == val) {
						return false;
					}
				}
				
				//같은 네모에 val값이 존재하면 return;
				int ind_row = (row/3)*3;
				int ind_col = (col/3)*3;
				
				for(int i = ind_row ; i < ind_row+3 ; i ++) {
					for(int j = ind_col ; j < ind_col +3 ; j++) {
						if(arr[i][j] == val)
							return false;
					}
				}
				return true;//가능할 경우.
	}

}
