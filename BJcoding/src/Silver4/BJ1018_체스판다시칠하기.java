package Silver4;

import java.io.*;
public class BJ1018_체스판다시칠하기 {	//36min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		int B[][] = new int[N][M];//왼쪽위 B로 시작.
		//int W[][] = new int[N][M];//왼쪽위 W로 시작.
		//따로 저장하려고 했는데 그냥 8*8=64에서 B배열에 저장된 수 다 더한 값 빼면 됨.
		//정확히 B배열과 W배열은 숫자가 반대로 저장됨. 0<->1
		
		for(int i=0;i<N;i++) {
			str = br.readLine().split("");
			for(int j=0;j<M;j++) {
				if(str[j].equals("B")) {
					if((i+j)%2==0) //i+j가 짝수이면 왼쪽 위의 색이랑 같아야함.
						B[i][j]=0;
					else B[i][j]=1;//원래 B이면 안되고 W여야 함. 다시 칠해야 하는 수 ++.
				}else {//W가 입력되면
					if((i+j)%2==0) B[i][j]=1;
					else B[i][j]=0;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(B[i][j]);
			}
			System.out.println();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(1-B[i][j]);
			}
			System.out.println();
		}
		int min=64;
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				int temp=0;
				for(int a=i;a<i+8;a++)
					for(int b=j;b<j+8;b++) {
						temp+=B[a][b];
					}
				if(temp<min) min=temp;
				if(64-temp<min) min=64-temp;
				//왼쪽 위에서 W로 시작하는 것은 B로 시작하는 것과 숫자가 정반대임.
			}
		}
		System.out.println(min);
	}
}