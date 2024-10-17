import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] possTime;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]); // 참가자 수
        int T = Integer.parseInt(s[1]); // 스터디 시간

        possTime = new int[100_001];
        int maxTime=0;
        for(int i=0;i<N;i++){
            int K = Integer.parseInt(br.readLine());
            for(int j=0;j<K;j++){
                s = br.readLine().split(" ");

                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                maxTime = Math.max(maxTime,end);

                for(int k=start;k<end;k++){
                    possTime[k]++;
                }
            }
        }

        // 처음 0~T초까지의 시간만족도
        int maxSatis = 0;
        int maxStart=0;
        int maxEnd = T;
        for(int i=0;i<T;i++){
            maxSatis += possTime[i];
        }

        int nowStatis = maxSatis;
        for(int i=T;i<=maxTime;i++){
            nowStatis = nowStatis + possTime[i] - possTime[i-T];

            if(nowStatis>maxSatis){
                maxSatis = nowStatis;
                maxEnd = i+1;
                maxStart = i-T+1;
            }
        }

        System.out.println(maxStart+" "+maxEnd);
    }
}