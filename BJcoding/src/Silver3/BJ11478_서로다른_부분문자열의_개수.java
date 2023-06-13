package Silver3;

import java.io.*;
import java.util.*;

public class BJ11478_서로다른_부분문자열의_개수 {	//16min.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len=1;
		Set<String> set = new HashSet<>();
		while(str.length()>=len) {	//글자 수만큼 반복. 총 5번
			for(int i=0;i<str.length()-len+1;i++) {	//2글자 짜리를 구하려면 i=0부터 3까지 반복.
				set.add(str.substring(i, i+len));	//substring으로 자르기 위해 i번째 부터 길이에 맞춰 자르기
			}
			len++;
		}
		System.out.println(set.size());
	}
}