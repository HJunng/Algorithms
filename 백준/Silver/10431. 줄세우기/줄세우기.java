import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		String[] s;
		List<Integer> list;
		int count;
		while(P-- >0) {
			s = br.readLine().split(" ");
			int tc = Integer.parseInt(s[0]);
			sb.append(tc+" ");

			count = 0;
			list = new ArrayList<>();

			for(int i=1;i<=20;i++) {
				int num = Integer.parseInt(s[i]);
				int j=list.size()-1;
				for(;j>=0;j--) {
					if(list.get(j)<num) break;
				}
				count+=list.size()-j-1;
				list.add(j+1, num);
			}

			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
}