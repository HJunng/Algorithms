import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        Map<Integer,Integer> loc = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            loc.put(Integer.parseInt(s[i]), i+1);
        }

        int maxIncreaseLen = 1;
        int maxIncreaseStart = 1;
        int maxIncreaseEnd = 1;
        int increaseLen = 1;
        int increaseStart = 1;
        for(int i=2;i<=n;i++){
            int locA = loc.get(i-1);
            int locB = loc.get(i);

            if(locA<locB){ // 증가
                increaseLen++;
            } else { // 감소됨.
                increaseLen = 1;
                increaseStart = i;
            }

            // 최대 증가 수열 갱신
            if(increaseLen>maxIncreaseLen){
                maxIncreaseLen = increaseLen;
                maxIncreaseStart = increaseStart;
                maxIncreaseEnd = i;
            }
        }
        
        int cnt = 0;

        // LCS 맨 앞 ~ 1 까지 위치 옮기기
        for(int i=maxIncreaseEnd+1;i<=n;i++){
            int locA = loc.get(i-1);
            int locB = loc.get(i);

            if(locA>locB){
                cnt++;
                loc.put(i, n+1);
            }
        }

        // LCS 맨 뒤 ~ n 까지 위치 옮기기
        for(int i=maxIncreaseStart-1;i>=1;i--){
            int locA = loc.get(i);
            int locB = loc.get(i+1);

            if(locA>locB){
                cnt++;
                loc.put(i, 0);
            }
        }

        System.out.println(cnt);
    }
}