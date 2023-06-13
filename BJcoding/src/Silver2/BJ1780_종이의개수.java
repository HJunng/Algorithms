package Silver2;

import java.io.*;
public class BJ1780_종이의개수 { //15min.
	static int[][] arr;
	static int minus=0;
	static int zero=0;
	static int plus=0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		String[] str;
		for(int i=0;i<N;i++) {
			str = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		PaperCount(0,0,N);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

	private static void PaperCount(int i, int j, int n) {
		
		//모두 같은 색이면 -1,0,1인지에 따라 색종이 개수를 추가한다.
		if(checkSame(i,j,n)) {
			if(arr[i][j]==-1) {
				minus++;
				return;
			}else if(arr[i][j]==0) {
				zero++;
				return;
			}else {
				plus++;
				return;
			}
		}
		else { //색이 같지 않으면 9분할.
			n /=3;
			PaperCount(i, j, n);
			PaperCount(i, j+n, n);
			PaperCount(i, j+2*n, n);
			
			PaperCount(i+n, j, n);
			PaperCount(i+n, j+n, n);
			PaperCount(i+n, j+2*n, n);
			
			PaperCount(i+2*n, j, n);
			PaperCount(i+2*n, j+n, n);
			PaperCount(i+2*n, j+2*n, n);
		}
	}

	private static boolean checkSame(int i, int j, int n) {
	
		boolean result=true;
		int start=arr[i][j];
		
		for(int a=i;a<i+n;a++) {
			if(!result) 
				break;
			
			for(int b=j;b<j+n;b++) {
				if(arr[a][b]!=start) {
					result=false;
					break;
				}
			}
		}
		return result;
	}
}