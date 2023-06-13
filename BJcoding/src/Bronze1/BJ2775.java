package Bronze1;

import java.io.*;

public class BJ2775 {	//60min

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		/*
		 * 왜 그런지 모르겠음 *
		 * String str[] = br.readLine.split("");
		 * int T = Integer.parseInt(str[0]);
		 * 
		 * 이렇게 두줄로 쓰는데 왜 이렇게 하면 안되고 저걸 한줄로 바꿨더니 되는 줄 모르겠음.
		 */
		int A[][] = new int [15][15];
		
		for(int b=1;b<15;b++) {	//0층은 무조건 호수=인원
			A[0][b]=b;
			A[b][1]=1;
		}
		for(int a=1;a<15;a++) {	//아파트 인원수 채우는 배열
			for(int b=2;b<15;b++) {
				A[a][b] = A[a][b-1]+A[a-1][b];
			}
		}
		for(int i=0;i<T;i++) {
			int k = Integer.parseInt(br.readLine());	//층수
			// 원래 두줄 이었던 걸 한줄로 바꿨더니 14 14까지 계산 됨.....왜지...?
			int n = Integer.parseInt(br.readLine());	//호수
			
			System.out.println(A[k][n]);
		}
	}

}
