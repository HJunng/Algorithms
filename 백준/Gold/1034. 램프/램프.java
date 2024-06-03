import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Map<String,Integer> pattern = new HashMap<>(); // 행 패턴 개수
        for(int i=0;i<n;i++){
            String lamp = br.readLine();
            pattern.put(lamp, pattern.getOrDefault(lamp,0)+1);
        }

        int k = Integer.parseInt(br.readLine());
        int isOdd = k%2;
        if(k>50) k=50; // 최대 50열만 나올 수 있으므로 50까지 줄이기

        int max = 0;
        for(String p : pattern.keySet()){

            int zeroCnt = 0; // 0 개수 파악
            for(int i=0;i<p.length();i++){
                if(p.charAt(i)=='0') zeroCnt++;
            }

            // 짝홀 맞아야함. -> 원하는 숫자 만들 수 있음.
            if(zeroCnt%2 != isOdd) continue;

            // 0 개수가 k개 이하여야 함.
            if(zeroCnt<=k && pattern.get(p)>max){
                max = pattern.get(p);
            }
        }

        System.out.println(max);
    }
}