package Gold4;

import java.io.*;

public class BJ9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String bomb = br.readLine();
		
		
		while(true) {
			if(str==null) {
				str = "FRULA";
				break;
			}
			
			String[] splitedStr = str.split(bomb);
			
			if(splitedStr.length==0) {
				str = "FRULA";
				break;
			}
			
			str = splitedStr[0];
			for(int i=1;i<splitedStr.length;i++)
				str = str.concat(splitedStr[i]);

			if(splitedStr.length==1) break;
		}
		System.out.println(str);
	}
}