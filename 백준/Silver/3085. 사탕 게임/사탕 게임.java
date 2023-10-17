import java.io.*;

public class Main {
	static int maxlen=1;
	public static void main(String[] args) throws Exception{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] board = new char[N][N];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			
			for(int j=0;j<N;j++) {
				board[i][j]=s.charAt(j);
			}
		}
		
		int nowMaxlen = findMaxLen(board,N);
		if(nowMaxlen==N) { // 현재 상태로 이미 최대 개수가 나오면 출력하고 종료.
			System.out.println(N);
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				moveBoard(i,j,board,N);
				if(maxlen==N) break;
			}
			if(maxlen==N) break;
		}
		System.out.println(maxlen);
		
	}
	static void moveBoard(int x, int y, char[][] board, int N) {
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		for(int dir=0;dir<4;dir++) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			if(nx>=0 && nx<N && ny>=0 && ny<N) { // 범위를 벗어나지 않으면 교환가능.
				char temp = board[x][y];
				board[x][y] = board[nx][ny];
				board[nx][ny] = temp;
				
				int len = findMaxLen(board,N);
				if(len>maxlen) maxlen=len;
				
				temp = board[x][y];
				board[x][y] = board[nx][ny];
				board[nx][ny] = temp;
			}
		}
		
	}
	
	static int findMaxLen(char[][] board, int N) {
		int maxlen=1;
		
		for(int i=0;i<N;i++) { // 행에서 가장 긴 길이 
			char first = board[i][0];
			int len=1;
			for(int j=1;j<N;j++) {
				if(board[i][j]!=first) { // 연속되지 않은 문자이면 
					if(len>maxlen) maxlen=len;
					len=1; // 다시 len 초기화
					first = board[i][j];
				}else {
					len++;
				}
			}
			if(len>maxlen) maxlen=len;
		}
		
		if(maxlen==N) return maxlen;
		
		for(int i=0;i<N;i++) { // 열에서 가장 긴 길이 
			char first = board[0][i];
			int len = 1;
			for(int j=1;j<N;j++) {
				if(board[j][i]!=first) {
					if(len>maxlen) maxlen=len;
					len=1;
					first = board[j][i];
				}else {
					len++;
				}
			}
			if(len>maxlen) maxlen=len;
		}
		
		return maxlen;
	}
}