package Silver3;

import java.io.*;
import java.util.*;
public class BJ1021_회전하는큐 { //40min. 답.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		str = br.readLine().split(" ");
		LinkedList<Integer> d = new LinkedList<>();
		
		for(int i=1;i<=n;i++)
			d.add(i);
		
		int count=0;
		for(int i=0;i<m;i++) { // 출력할 수의 개수만큼 반복
			
			int want = Integer.parseInt(str[i]); // 뽑고자 하는 수
			int want_index = d.indexOf(want); // 뽑아야하는 수의 index
			
			//뽑아야하는 원소가 중간지점보다 앞에 있을 경우.
			if(want_index <= d.size()/2) {
				//want_index보다 앞에 있는 수들을 모두 뒤로 보낸다.
				while(d.peekFirst() != want) {
					count++;
					d.addLast(d.pollFirst());
				}
			}else {
				//want_index를 포함하여 뒤에 있는 원소들을 앞으로 넣음.
				while(d.peekFirst() != want) {
					count++;
					d.addFirst(d.pollLast());
				}
			}
			//연산 끝나면 맨 앞(원하는 수) 출력.
			d.pollFirst();
		}
		System.out.println(count);
	}
}