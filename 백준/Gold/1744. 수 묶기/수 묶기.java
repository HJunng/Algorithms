import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> seq = new ArrayList<>();
		for(int i=0;i<n;i++) seq.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(seq, Collections.reverseOrder());
		//System.out.println(seq);
		
		int sum=0;
		//양수는 큰 것부터 두개씩 묶어서 곱하는게 제일 큼.
		while(!seq.isEmpty() && seq.get(0)>0) {
			if(seq.get(0)==1) {
				sum+=1;
				seq.remove(0);
				continue;
			}
			
			if(seq.size()>=2 && seq.get(1)>1) {
				sum+=seq.get(0)*seq.get(1);
				seq.remove(0);
				seq.remove(0);
			}else {
				sum+=seq.get(0);
				seq.remove(0);
			}
		}
		
		//오름차순 정렬
		Collections.sort(seq);
		//System.out.println(seq);
		
		while(!seq.isEmpty()) {
			if(seq.size()>=2) {
				sum+=seq.get(0)*seq.get(1);
				seq.remove(0);seq.remove(0);
			}else {
				sum+=seq.get(0);
				seq.remove(0);
			}
		}
		System.out.println(sum);
	}
}