import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<String,Integer> enter = new HashMap<>();
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			
			if(s[1].equals("enter"))
				enter.put(s[0],enter.getOrDefault(s[0], 0)+1);
			else
				enter.put(s[0], enter.get(s[0])-1);
		}
		
		ArrayList<String> list = new ArrayList<>(enter.keySet());
		Collections.sort(list,Collections.reverseOrder());
		
		for(String name : list) {
			if(enter.get(name)>0)
				System.out.println(name);
		}
			
	}
}