package Silver3;

import java.io.*;

public class BJ1002_터렛 {	//32min.

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int A[] = new int[6];
		for(int i=0;i<T;i++) {
			String str[] = br.readLine().split(" ");
			for(int j=0;j<6;j++)
				A[j] = Integer.parseInt(str[j]);
			
			if(A[0]==A[3] && A[1]==A[4]) {	//좌표가 겹칠 때.
				if(A[2]==A[5]) {//거리까지 같으면 접점이 무한개 나옴.
					System.out.println(-1);
					continue;
				}else {//거리가 다르면 접점 없음.
					System.out.println(0);
					continue;
				}
			}
			
			double len = Math.sqrt(Math.pow(A[3]-A[0], 2)+Math.pow(A[4]-A[1], 2));
			//직원 조규현과 백승환의 거리 구하기
			
			//r1과 r2 중에 더 큰 것으로 외접할때를 구해야 하기 때문에 경우 나눔.
			if(A[2]>=A[5]) {	//r1 >= r2 일때
				if(A[2]+A[5]>len && A[2]-A[5]<len)//접점 두개. 내접 외접 직전까지.
					System.out.println(2);
				else if(A[2]+A[5]==len || A[2]-A[5]==len)//내접, 외접
					System.out.println(1);
				else
					System.out.println(0);
			}else {	//r2 > r1 일때
				if(A[2]+A[5]>len && A[5]-A[2]<len)//접점 두개. 내접 외접 직전까지.
					System.out.println(2);
				else if(A[2]+A[5]==len || A[5]-A[2]==len)//내접, 외접
					System.out.println(1);
				else
					System.out.println(0);
			}
		}
	}
}