package Silver5;

import java.io.*;
import java.util.*;

public class BJ1181_단어정렬 {		//18min.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int N = Integer.parseInt(str);
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			str = br.readLine();
			if(list.contains(str))		//같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
				continue;
			else
				list.add(str);
		}
		Collections.sort(list, new Comparator <String>() {
			public int compare(String a, String b) {
				if(a.length()==b.length()) {	//두 개의 길이가 같을 때
					return a.compareTo(b);	//a가 b보다 사전순으로 뒤에 있으면 양수 출력됨.
				}else {
					return a.length()-b.length();	//길이가 다르다면 a길이가 더 길 때 양수.
				}
			}
		});
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}

}
