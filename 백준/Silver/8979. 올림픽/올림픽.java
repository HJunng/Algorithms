import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

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

		PriorityQueue<Country> pq = new PriorityQueue<>(new Comparator<Country>() {
			public int compare(Country c1 , Country c2) {
				if(c1.goldCnt != c2.goldCnt) return c2.goldCnt - c1.goldCnt;
				else if(c1.silverCnt != c2.silverCnt) return c2.silverCnt - c1.silverCnt;
				else return c2.bronzeCnt - c1.bronzeCnt;
			}
		});

		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");

			int number = Integer.parseInt(s[0]);
			int goldCnt = Integer.parseInt(s[1]);
			int silverCnt = Integer.parseInt(s[2]);
			int bronzeCnt = Integer.parseInt(s[3]);

			pq.add(new Country(number, goldCnt, silverCnt, bronzeCnt));
		}

		int rank = 0;
		Country before = null;
		while(!pq.isEmpty()) {
			Country c = pq.poll();

			// 등수 구하기
			if(before == null) rank++;
			else if(c.goldCnt != before.goldCnt || c.silverCnt != before.silverCnt
				|| c.bronzeCnt != before.bronzeCnt) {
				rank++;
			}

			if(c.countryNumber == K) break;

			before = c;
		}

		System.out.println(rank);

	}
}