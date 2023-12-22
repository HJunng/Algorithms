import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]); // 단어의 개수 
		int M = Integer.parseInt(s[1]); // 외울 단어의 길이 
		
		Map<String, Integer> dic = new HashMap<>();
		for(int i=0;i<N;i++) {
			String word = br.readLine();
			if(word.length()>=M)
				dic.put(word, dic.getOrDefault(word, 0)+1);
		}
		
		ArrayList<String> dicKeys = new ArrayList<>(dic.keySet());
		
		Collections.sort(dicKeys, new Comparator<String>() {
			public int compare(String a, String b) {
				if(dic.get(a)<dic.get(b)) return 1;
				else if(dic.get(a)>dic.get(b)) return -1;
				else {
					if(a.length()<b.length()) return 1;
					else if(a.length()>b.length()) return -1;
					else {
						return a.compareTo(b);
					}
				}
			}
		});
	
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<dicKeys.size();i++) 
			sb.append(dicKeys.get(i)).append("\n");
		
		System.out.println(sb);
	}
}