package Gold4;

import java.io.*;
import java.util.Arrays;
public class BJ2580_스도쿠 {	//시간초과.
	public static int arr[][] = new int[9][9];//스도쿠
	public static boolean blank[] = new boolean[10];//1~9까지 다 있는지 확인.
	public static int remain=0;	//빈 칸 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[];
		for(int i=0;i<9;i++) {//입력값 받아오기
			str=br.readLine().split(" ");
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(str[j]);
				if(arr[i][j]==0) remain++;	//빈칸 개수 넣기.
			}
		}
		while(remain!=0) {	//빈칸이 없을때까지 반복.
			for(int i=0;i<9;i++) {
				rows(i);
				cols(i);
			}
			for(int i=0;i<=6;i+=3) {//3*3네모 안의 숫자들 스도쿠.
				for(int j=0;j<=6;j+=3) {
					square(i,j);
				}
			}
		}
		for(int i=0;i<9;i++) {	
			for(int j=0;j<9;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void square(int n, int m) {//3*3네모 안의 숫자들 스도쿠.
		int blanks=0;
		int blankCol=-1;
		int blankRow=-1;
		Arrays.fill(blank, false);
		for(int i=n;i<n+3;i++) {
			for(int j=m;j<m+3;j++) {
				blank[arr[i][j]]=true;
				if(arr[i][j]==0) {
					blanks++;
					blankRow=i;
					blankCol=j;
				}
			}
		}
		if(blanks!=1) return;//빈칸이 1개가 아니면 
		else {
			for(int i=1;i<=9;i++) {	//빈칸이 1개이면 1~9중에 없는 값 집어 넣기.
				if(!blank[i]) arr[blankRow][blankCol] = i;
			}
			remain--; //남은 빈칸 수 -1
		}
	}
	private static void cols(int n) {//n열 스도쿠
		int blanks=0;
		int blankCol=-1;
		Arrays.fill(blank, false);
		for(int i=0;i<9;i++) {
			blank[arr[i][n]]=true;	//1~9까지 값이 있으면 true.
			if(arr[i][n]==0) {
				blanks++;
				blankCol=i;
			}
		}
		if(blanks!=1) return;//빈칸이 1개가 아니면 
		else {
			for(int i=1;i<=9;i++) {	//빈칸이 1개이면 1~9중에 없는 값 집어 넣기.
				if(!blank[i]) arr[blankCol][n] = i;
			}
			remain--; //남은 빈칸 수 -1
		}
	}
	private static void rows(int n) {//n행 스도쿠.
		int blanks=0;
		int blankRow=-1;
		Arrays.fill(blank, false);
		for(int i=0;i<9;i++) {
			blank[arr[n][i]]=true;	//1~9까지 값이 있으면 true.
			if(arr[n][i]==0) {
				blanks++;
				blankRow=i;
			}
		}
		if(blanks!=1) return;//빈칸이 1개가 아니면 
		else {
			for(int i=1;i<=9;i++) {	//빈칸이 1개이면 1~9중에 없는 값 집어 넣기.
				if(!blank[i]) arr[n][blankRow] = i;
			}
			remain--; //남은 빈칸 수 -1
		}
	}

}
