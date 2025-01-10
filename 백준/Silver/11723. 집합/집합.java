import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());

        String[] s;
        Set<Integer> set = new HashSet<>();

        int num = 0;
        StringBuilder sb  = new StringBuilder();
        while(M-- >0) {
            // 입력받기
            st = new StringTokenizer(br.readLine());

            // 변수 처리
            String command = st.nextToken();
            if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());

            if(command.equals("add")) {
                set.add(num);
            } else if(command.equals("remove")) {
                set.remove(num);
            } else if(command.equals("check")) {
                if(set.contains(num)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if(command.equals("toggle")) {
                if(set.contains(num)) set.remove(num);
                else set.add(num);
            } else if(command.equals("all")) {
                set.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
            } else { // empty
                set.clear();
            }
        }
        System.out.println(sb);
    }
}