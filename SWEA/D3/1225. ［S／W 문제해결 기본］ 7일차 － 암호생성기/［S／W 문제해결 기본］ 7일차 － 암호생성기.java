import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++) {
            int test = Integer.parseInt(br.readLine());
            queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 큐 생성
            for(int i = 0; i < 8; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            solve();

            System.out.print("#" + t + " ");
            for(int i = 0; i < 8; i++) {
                System.out.print(queue.poll() +" ");
            }
            System.out.println();
        }
    }

    public static void solve() {
        int index = 1;
        // 맨앞의 원소 빼서 index 만큼 빼고 맨뒤로 보냄
        while(true) {
            int cur = queue.poll() - index;

            // 0이면 0넣고 break
            if(cur <= 0) {
                queue.offer(0);
                break;
            }
            else{
                queue.offer(cur);
            }

            index = (index % 5) + 1; // 5까지 감소하면 나머지 연산으로 다음 사이클 시작
        }
    }
}