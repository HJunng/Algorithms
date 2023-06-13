package Bronze1;

import java.io.*;
import java.util.Arrays;

public class BJ1037_약수 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());//진짜 약수의 개수
		
		int A[] = new int[num];
		String str[] = br.readLine().split(" ");
		for(int i=0;i<num;i++)
			A[i]=Integer.parseInt(str[i]);
		
		Arrays.sort(A);//정렬
		
		if(num>=2) {//진짜 약수의 개수가 2개 이상이면
			System.out.println(A[0]*A[num-1]);//맨 앞의 약수와 맨 뒤약수는 서로 짝임.
		}else if(num==1) {//진짜 약수의 개수가 1개이면
			System.out.println(A[0]*A[0]);
		}
	}

}
