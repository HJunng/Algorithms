package Silver5;

import java.io.*;
import java.util.*;

public class BJ10814_나이순정렬 {		//36min

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		String arr[][] = new String[N][2];
		
		for(int i=0;i<N;i++) {
			str = br.readLine().split(" ");
			arr[i][0] = str[0];
			arr[i][1] = str[1];
		}
		Arrays.sort(arr, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				if(s1[0]==s2[0]) {	//나이가 같으면		//s1[0].equals(s2[0])으로 하면 안됨. 이유가 뭘까?
					return 1;	//자리 안바꿈.(먼저 가입한 순서)
				}else {
					return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
					//return s1[0].compareTo(s2[0]);	//숫자 들어있어서 비교 안됨.
				}
			}
		});
		for(int i=0;i<N;i++)
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		System.out.println(sb);
	}
}
