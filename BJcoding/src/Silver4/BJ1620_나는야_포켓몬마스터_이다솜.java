package Silver4;

import java.io.*;
import java.util.*;
public class BJ1620_나는야_포켓몬마스터_이다솜 {	//17min.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);	//도감에 수록되어있는 포켓몬 수 : N
		int M = Integer.parseInt(str[1]);	//맞춰야하는 문제 수 : M
		
		Map<Integer, String> map = new HashMap<>();	//숫자로 포켓몬 이름 찾기
		Map<String, Integer> map2 = new HashMap<>();//포켓몬 이름으로 도감 번호 찾기.
		for(int i=0;i<N;i++) {
			map.put(i+1, br.readLine());
			map2.put(map.get(i+1), i+1);
		}
			
		for(int i=0;i<M;i++) {
			String s = br.readLine();
			if(isNumeric(s))	//주어진 문자열이 숫자인지 확인하는 함수.
				sb.append(map.get(Integer.parseInt(s))).append("\n");
			else {
				sb.append(map2.get(s)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean isNumeric(String s) {	//직접 만들어야 함.
		try {
			Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
