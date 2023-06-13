package Bronze1;

import java.io.*;

public class BJ1546 {		//1hour ㅈ같은 문제 짜증나

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		
		str = br.readLine().split(" ");
		int max=0;
		int score[] = new int[N];
		for(int i=0;i<N;i++) {
			score[i] = Integer.parseInt(str[i]);
			if(score[i]>max) max = score[i];
		}
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += score[i];
		}
		System.out.println((((double)sum/N)/max)*100);
	}

}
