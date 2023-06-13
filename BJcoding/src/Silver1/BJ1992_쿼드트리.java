package Silver1;

import java.io.*;
public class BJ1992_쿼드트리 { //15min.
	static int[][] arr; //주어진 배열
	static StringBuilder sb = new StringBuilder(); // 출력할 String
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		String[] str;
		for(int i=0;i<N;i++) { // 주어진 수 담기
			str = br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		QuadTree(0,0,N);
		System.out.println(sb);
	}
	/* 모두 같은 숫자이면 숫자를 출력하고, 그렇지 않으면 4분할 */
	private static void QuadTree(int i, int j, int n) {
		
		//checkSame함수를 통해 arr[i][j]부터 n*n개가 다 같은 숫자인지 체크.
		if(checkSame(i,j,n)) {
			sb.append(arr[i][j]); // 모두 같다면 그 색깔 StringBuilder에 저장.
			return;
		}
		else {
			//색이 모두 같지 않으면 4분할 해야하므로 사이즈 반으로 자름.
			n /= 2; 
			
			//분할이되면 괄호로 묶은 후, 4분할한 값 조사.
			sb.append("(");
			QuadTree(i,j,n);
			QuadTree(i,j+n,n);
			QuadTree(i+n,j,n);
			QuadTree(i+n,j+n,n);
			sb.append(")");
		}
	}
	/* arr[x][y]부터 오른쪽으로 n칸, 아래로 n칸이 모두 같은 숫자인지 확인 */
	private static boolean checkSame(int x, int y, int size) {
		
		boolean result=true;
		int start=arr[x][y];
		
		for(int i=x;i<x+size;i++) {
			if(!result)
				break;
			
			for(int j=y;j<y+size;j++) {
				if(arr[i][j]!=start) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
}