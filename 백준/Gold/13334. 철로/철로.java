import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Person {
        int num,start,end;
        private Person(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "["+this.num+" : "+this.start+" "+this.end+"]";
        }
    }
    static int INF = 100_000_001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 사람 수

        String[] s;
        int min = INF;
        int max = -INF;

        PriorityQueue<Person> beforeStart = new PriorityQueue<>((a,b) -> a.end-b.end);
        TreeSet<Integer> startPoints = new TreeSet<>();
        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");

            int home = Integer.parseInt(s[0]);
            int office = Integer.parseInt(s[1]);

            min = Math.min(min, Math.min(home,office));
            max = Math.max(max, Math.max(office,home));

            if(home>office){
                int temp = home;
                home = office;
                office = temp;
            }

            Person p = new Person(i,home,office);
            beforeStart.add(p);
            startPoints.add(p.start);
        }

        int d = Integer.parseInt(br.readLine()); // 철로 길이

        // 맨 처음 min ~ min+d 까지 선로에 포함된 사람 수 구하기.
        PriorityQueue<Person> include = new PriorityQueue<>((a,b) -> a.start-b.start);
        for(int i=0;i<=d;i++){
            int j = min+i;

            // i가 도착인게 있는지 확인
            while(!beforeStart.isEmpty() && j == beforeStart.peek().end) {
                Person p = beforeStart.poll();
                if(p.start>=min) include.offer(p);
            }
        }

        int maxCnt = include.size();

        // 슬라이딩 윈도우
        for(int sp : startPoints) {

            // i 이전에 start인 것들 다 빼기.
            while(!include.isEmpty() && include.peek().start<sp) {
                include.poll();
            }

            // i+d 로 추가된 end 있는지 확인하고, 추가
            int ep = sp + d;
            while(!beforeStart.isEmpty() && beforeStart.peek().end<=ep) {
                Person p = beforeStart.poll();
                if(p.start>=sp) include.add(p);
            }

            // maxCnt 갱신
            maxCnt = Math.max(maxCnt, include.size());
        }

        System.out.println(maxCnt);
    }
}