package Bronze5;

import java.io.*;

public class Practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		System.out.println(Integer.parseInt(str[0])-Integer.parseInt(str[1]));
	}

}
