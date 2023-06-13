package Bronze1;

import java.io.*;

public class BJ4344 {	//19분 11초

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int C = Integer.parseInt(str[0]);
		for(int i=0; i<C; i++) {
			str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			float sum=0;
			for(int j=1;j<=N;j++) 	sum +=Integer.parseInt(str[j]);
			sum /= N;
			int overNum = 0;
			for(int j=1;j<=N;j++) {
				if(Integer.parseInt(str[j])>sum)	overNum++;
			}
			float result = (float) overNum/N*100;		//float형으로 해야할지 double로 해야할지 몰랐는데 float으로 해야 오류 안남.
			System.out.printf("%.3f%% \n", result);		//printf를 사용한 소수점자릿수 출력 몰라서 알아봄.
		}
	}

}
