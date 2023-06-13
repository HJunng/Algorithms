package Bronze5;

import java.io.*;

public class BJ10952 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		while( !str[0].equals("0") || !str[1].equals("0") ){
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			System.out.println(a+b);
			str = br.readLine().split(" ");
		}
		
	}

}
