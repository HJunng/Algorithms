package Bronze5;

import java.io.*;
public class BJ11718_그대로출력하기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str="";
		
		while((str = br.readLine())!=null) {
			System.out.println(str);
		}
	}
}
