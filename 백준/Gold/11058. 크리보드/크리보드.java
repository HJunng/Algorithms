import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Board{
        long cntA, buffer;
        private Board(long cntA, long buffer){
            this.cntA = cntA;
            this.buffer = buffer;
        }

        @Override
        public String toString() {
            return cntA + " " + buffer;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N<=6) {
            System.out.println(N); return;
        }

        List<Board>[] b = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            b[i] = new ArrayList<>();
            b[i].add(new Board(i,0)); // 0번째는 무조건 그냥 A*i개 출력

            if(i>=4){ // 컨+A+C+V
                // i-3에서 나올 수 있는 가장 큰 수.
                long maxA = b[i-3].stream().max((b1,b2)->Long.compare(b1.cntA, b2.cntA)).get().cntA;
                b[i].add(new Board(maxA*2, maxA));
            }
            if(i>=5){ // 이전 + 컨+V
                // i-1 리스트에서 1번째 부터 가져와서 컨V 해보기
                for(int j=1;j<b[i-1].size();j++){
                    Board before = b[i-1].get(j);
                    // 이전에서 컨V 한거가 방금 넣은 cntA보다 커야 함.
                    if(before.cntA+before.buffer > b[i].get(b[i].size()-1).cntA){
                        b[i].add(new Board(before.cntA+before.buffer, before.buffer));
                    }
                }
            }
//            System.out.println(b[i]);
        }

        System.out.println(
                b[N].stream().max((b1,b2)->Long.compare(b1.cntA, b2.cntA)).get().cntA
        );

    }
}