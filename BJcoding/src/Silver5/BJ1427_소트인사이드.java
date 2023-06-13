package Silver5;

import java.io.*;
import java.util.*;
public class BJ1427_소트인사이드 {		//10min.
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	//매번 print하는 것을 막기 위해 StringBuilder 사용.
		ArrayList<Integer> list = new ArrayList<>();
		String str[] = br.readLine().split("");
		
		for(int i=0;i<str.length;i++)
			list.add(Integer.parseInt(str[i]));
		
		Collections.sort(list, Collections.reverseOrder());	//ArrayList 내림차순 정렬.
		
		for(int i=0;i<str.length;i++)
			sb.append(list.get(i));		//StringBuilder에 문자열 더하는 것으로 속도 향상, 부하 낮출 수 있다.
		System.out.println(sb);
	}
}