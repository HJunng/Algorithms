import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "("+this.x+", "+this.y+")";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 드래곤 커브 개수

        int[] dx = {1,0,-1,0}; // (->, ↑, ←, ↓)
        int[] dy = {0,-1,0,1};

        String[] s;

        Set<Point> allPoints = new HashSet<>();
        for(int i=0;i<N;i++){
            s = br.readLine().split(" ");

            int x = Integer.parseInt(s[0]); // (x,y) 드래곤 커브 시작점
            int y = Integer.parseInt(s[1]);
            int d = Integer.parseInt(s[2]); // 시작 방향 (->, ↑, ←, ↓)
            int g = Integer.parseInt(s[3]); // 세대


            // 0세대 ~ g세대 까지의 회전했을 때의 방문 점들 List 구함
            List<Point> points = new ArrayList<Point>();
            points.add(new Point(x,y)); //0세대
            points.add(new Point(x+dx[d], y+dy[d]));
//            System.out.println("0세대 : "+ points+"\n");

            for(int j=1;j<=g;j++){
//                System.out.print(j+"세대 : ");

                List<Point> rotatedPoints = getRotatedPoints(points, points.get(points.size()-1));
                points.addAll(rotatedPoints);

//                System.out.println(points);
//                System.out.println("끝점 : "+points.getLast());
//                System.out.println();
            }

            allPoints.addAll(points);
        }
//        System.out.println(allPoints);

        // 4점이 모두 드래곤 커브에 포함되는지 확인
        int answer = 0;

        for(Point p : allPoints){
            if(allPoints.contains(new Point(p.x+1,p.y))
                    && allPoints.contains(new Point(p.x,p.y+1))
                    && allPoints.contains(new Point(p.x+1,p.y+1))){
                answer++;
            }
        }

        System.out.println(answer);
    }
    static List<Point> getRotatedPoints(List<Point> points, Point center){
        List<Point> rotatedPoints = new ArrayList<Point>();


        // 모든 points에서 center만큼 빼고 -> 시계방향 회전 -> 다시 원상태로 이동
        for(int i=points.size()-1;i>=0;i--){
            Point p = points.get(i);
            if(p.equals(center)) continue; // 회전 중점이 되는 점은 회전해도 같은 위치.

            // 1. 중점 center를 (0,0)으로 이동
            int x = p.x - center.x;
            int y = p.y - center.y;

            // 2. 시계방향 회전
            int nx = -y;
            int ny = x;

            // 3. 중점 옮긴만큼 다시 이동
            nx += center.x;
            ny += center.y;

            if(nx<0 || ny<0 || nx>100 || ny>100) continue; // 범위 벗어나면 추가 x.

            rotatedPoints.add(new Point(nx,ny));
        }

        return rotatedPoints;
    }
}
