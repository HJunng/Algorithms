import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
	
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		int start, end, cnt = 0;
		s = br.readLine().split("");
		for(int i=0;i<N;i++) {
			if(s[i].equals("P")){
				
				start = i-K>=0? i-K : 0;
				end = i+K<N? i+K : N-1;
				
				for(int j=start;j<=end;j++) {
					if(s[j].equals("H")) {
						cnt++;
						s[j]=".";
						break;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}