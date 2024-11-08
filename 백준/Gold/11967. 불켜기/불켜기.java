import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] onLight;
    static boolean[][] visited;
    static Map<Location, List<Location>> switchList;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n;

    static class Location {
        int x,y;
        private Location(int x, int y) {
            this.x = x; this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            return this.x==((Location)obj).x && this.y==((Location)obj).y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]); // 방 세로, 가로 개수
        int m = Integer.parseInt(s[1]); // 스위치 연결 개수

        switchList = new HashMap<>(); // 연결된 스위치 리스트
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                switchList.put(new Location(i, j), new ArrayList<Location>());
            }
        }

        onLight = new boolean[n][n];
        onLight[0][0] = true;
        int cnt = 1;

        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");

            // 위치
            int x = Integer.parseInt(s[0])-1;
            int y = Integer.parseInt(s[1])-1;
            Location now = new Location(x,y);

            // 불을 켤 수 있는 곳
            int a = Integer.parseInt(s[2])-1;
            int b = Integer.parseInt(s[3])-1;
            Location next = new Location(a,b);

            switchList.get(now).add(next);
        }

        Deque<Location> q = new LinkedList<Location>();
        q.add(new Location(0,0));
        visited = new boolean[n][n];
        visited[0][0] = true;

//        PriorityQueue<Location> turnOnNotVisit = new PriorityQueue<>(new Comparator<Location>() {
//            @Override
//            public int compare(Location o1, Location o2) {
//                boolean flag1 = isPossible(o1);
//                boolean flag2 = isPossible(o2);
//
//                return Boolean.compare(flag2,flag1);
//            }
//        });
        List<Location> turnOnNotVisit = new ArrayList<>();

        while(!q.isEmpty()){
            Location now = q.poll();
//            System.out.println("now : "+now.toString());

            // 현재 위치에서 불 켜기
            for(Location turnOn : switchList.get(now)){
                if(!onLight[turnOn.x][turnOn.y]) {
                    onLight[turnOn.x][turnOn.y] = true;
                    cnt ++;
//                    System.out.println("turn on : "+ turnOn.toString());

                    // 이전에 방문하지 않았던 곳인데, 지금 불 켜짐
                    if(!visited[turnOn.x][turnOn.y] ){
                        turnOnNotVisit.add(turnOn);
                    }
                }
            }

            // 이전에 못갔던 곳인데, 불켜져서 방문할 수 있는 곳 q 앞에 넣기.
//            while(!turnOnNotVisit.isEmpty() && isPossible(turnOnNotVisit.peek())) {
//                q.offerFirst(turnOnNotVisit.poll());
//            }
            for(int i=0;i<turnOnNotVisit.size();i++) {
                Location loc = turnOnNotVisit.get(i);
                if(isPossible(loc)) {
                    visited[loc.x][loc.y] = true;
                    q.offerFirst(loc);
                    turnOnNotVisit.remove(i); i--;
                }
            }

            // 상하좌우 이동
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];

                // 범위 안이고, 불이켜져 있고, 아직 방문하지 않음.
                if(inRange(nx,ny) && onLight[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.addLast(new Location(nx,ny));
                }
            }
        }

        System.out.println(cnt);
    }
    static boolean inRange(int x, int y){
        return (x>=0 && y>=0 && x<n && y<n);
    }
    static boolean isPossible(Location loc) {
        boolean isPoss = false;

        int x = loc.x; int y = loc.y;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(!inRange(nx,ny)) continue;
            if(visited[nx][ny]) return true;
        }

        return isPoss;
    }
}