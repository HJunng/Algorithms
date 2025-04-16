import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	static class Country {
		int countryNumber, goldCnt, silverCnt, bronzeCnt;
		private Country(int countryNumber, int goldCnt, int silverCnt, int bronzeCnt) {
			this.countryNumber = countryNumber;
			this.goldCnt = goldCnt;
			this.silverCnt = silverCnt;
			this.bronzeCnt = bronzeCnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]); // 국가 수
		int K = Integer.parseInt(s[1]); // 등수를 알고 싶은 국가

		List<Country> list = new ArrayList<>();

		Country find = null;
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");

			int number = Integer.parseInt(s[0]);
			int goldCnt = Integer.parseInt(s[1]);
			int silverCnt = Integer.parseInt(s[2]);
			int bronzeCnt = Integer.parseInt(s[3]);

			Country temp = new Country(number, goldCnt, silverCnt, bronzeCnt);

			if(number == K) find = temp;
			else list.add(temp);
		}

		int rank = 0;
		for(Country c : list) {
			if(c.goldCnt > find.goldCnt) rank++;
			else if (c.goldCnt==find.goldCnt && c.silverCnt>find.silverCnt) rank++;
			else if(c.goldCnt==find.goldCnt && c.silverCnt==find.silverCnt
			&& c.bronzeCnt>find.bronzeCnt) rank++;
		}

		System.out.println(rank+1);

	}
}