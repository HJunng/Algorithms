package Silver4;

import java.io.*;
import java.util.Arrays;

public class BJ11399_atm_2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		int[] time = new int[n];
		
		for(int i=0;i<n;i++) time[i]=Integer.parseInt(s[i]);
		
		Arrays.sort(time);//대기시간 짧은순으로 정렬
		
		int sum=0;//대기시간 총합
		int now=0;//현재시각
		for(int i=0;i<time.length;i++) {
			sum+=now+time[i];
			now+=time[i];
		}
		System.out.println(sum);
	}
}
