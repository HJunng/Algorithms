package Bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10951 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		while((str = br.readLine())!=null) {	//scanner로 받으면 쉽게 풀리는 문제인데 BufferedReader로 받아서 null검사를 따로 해주고
			String s[] = str.split(" ");		//반복문 안에서 split으로 한번 더 나눠야 한다.
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			System.out.println(a+b);
		}
	}

}
