import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s;
		while(!(s = br.readLine()).equals("end")) {

			if(isContainVowel(s) && isNot3Sequence(s) && noDoubleLetter(s)) {
				sb.append("<"+s+"> is acceptable.\n");
			} else {
				sb.append("<"+s+"> is not acceptable.\n");
			}
		}

		System.out.println(sb.toString());
	}

	static boolean isContainVowel(String s) {
		for(char c : vowels) {
			if(s.contains(String.valueOf(c))) return true;
		}
		return false;
	}

	static boolean isNot3Sequence(String s) {
		String vowels = "aeiou";
		int vowelCount = 0;
		int consonantCount = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (vowels.indexOf(c) >= 0) {
				vowelCount++;
				consonantCount = 0;
			} else {
				consonantCount++;
				vowelCount = 0;
			}

			if (vowelCount == 3 || consonantCount == 3) {
				return false;
			}
		}

		return true;
	}

	static boolean noDoubleLetter(String s) {
		for (int i = 1; i < s.length(); i++) {
			char prev = s.charAt(i - 1);
			char curr = s.charAt(i);
			if (prev == curr && !(curr == 'e' || curr == 'o')) {
				return false;
			}
		}
		return true;
	}

}