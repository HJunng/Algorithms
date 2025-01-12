import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int n;
        while(T-- >0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            // 수첩 1에 적은 정수
            Set<Integer> note1 = new HashSet<>();
            for(int i = 0; i < n; i++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }

            // 수첩 2에 적은 정수
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++) {
                if(note1.contains(Integer.parseInt(st.nextToken())))
                    sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}