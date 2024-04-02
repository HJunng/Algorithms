import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    static char[][] map;
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String[] wh = br.readLine().split(" ");
            w = Integer.parseInt(wh[0]);
            h = Integer.parseInt(wh[1]);
            map = new char[h][w];

            Point start = null;

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@') start = new Point(i, j);
                }
            }

            int result = escape(start);
            if (result == -1) System.out.println("IMPOSSIBLE");
            else System.out.println(result);
        }
    }

    static int escape(Point start) {
        Queue<Point> q = new LinkedList<>();
        Queue<Point> fire = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];

        q.offer(start);
        visited[start.x][start.y] = true;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '*') fire.offer(new Point(i, j));
            }
        }

        int time = 0;

        while (!q.isEmpty()) {
            // 불이 번짐
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                Point cur = fire.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] != '#' && map[nx][ny] != '*') {
                        map[nx][ny] = '*';
                        fire.offer(new Point(nx, ny));
                    }
                }
            }

            // 상근이 이동
            size = q.size();
            for (int i = 0; i < size; i++) {
                Point cur = q.poll();
                if (cur.x == 0 || cur.x == h - 1 || cur.y == 0 || cur.y == w - 1) return time + 1;
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
            time++;
        }

        return -1;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
