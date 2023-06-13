package Silver4;

import java.io.*;
public class BJ11047_동전0 {	//11m.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);	//가지고 있는 동전 종류
		int k = Integer.parseInt(str[1]);
		
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {	//가지고 있는 동전 종류 저장
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int result=0;
		for(int i=n-1;i>=0;i--) { //큰 돈 순으로 
			if(k<=0) break; //돈이 0원이면 즉시 종료
			if(k/arr[i]>0) { //나눠지면
				result += k/arr[i]; //몇 개로 나눠지는지
				k = k%arr[i]; //남은거 다시 k에 저장
			}
		}
		System.out.println(result);
	}
}