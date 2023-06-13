package Silver3;

import java.io.*;
import java.util.*;
public class BJ9375_패션왕신해빈 {	//30min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str[];
		
		for(int i=0;i<T;i++) {
			Map<String,Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for(int j=0;j<n;j++) {
				str = br.readLine().split(" ");
				map.put(str[1], map.getOrDefault(str[1], 1)+1);//옷종류마다 개수를 하나씩 더함.
			}
			int result=1;
			for(int num : map.values()) {
				result *=num;
			}
			System.out.println(result-1);//알몸인 경우 제외.
		}
	}
}