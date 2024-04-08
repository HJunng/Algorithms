import java.util.Scanner;

public class Main {
    static int R, C;
    static int[][] room;
    static int[] cleaner = new int[2];

    // 미세먼지 확산
    static void spreadDust() {
        int[][] spreadAmount = new int[R][C];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (room[r][c] > 0) {
                    int spreadCount = 0;
                    int amount = room[r][c] / 5;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && room[nr][nc] != -1) {
                            spreadAmount[nr][nc] += amount;
                            spreadCount++;
                        }
                    }
                    room[r][c] -= amount * spreadCount;
                }
            }
        }

        // 미세먼지 확산 결과 반영
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                room[r][c] += spreadAmount[r][c];
            }
        }
    }

    // 공기청정기 작동
    static void operatePurifier() {
        // 위쪽 공기청정기
        for (int r = cleaner[0] - 1; r > 0; r--) {
            room[r][0] = room[r - 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            room[0][c] = room[0][c + 1];
        }
        for (int r = 0; r < cleaner[0]; r++) {
            room[r][C - 1] = room[r + 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            room[cleaner[0]][c] = room[cleaner[0]][c - 1];
        }
        room[cleaner[0]][1] = 0;

        // 아래쪽 공기청정기
        for (int r = cleaner[1] + 1; r < R - 1; r++) {
            room[r][0] = room[r + 1][0];
        }
        for (int c = 0; c < C - 1; c++) {
            room[R - 1][c] = room[R - 1][c + 1];
        }
        for (int r = R - 1; r > cleaner[1]; r--) {
            room[r][C - 1] = room[r - 1][C - 1];
        }
        for (int c = C - 1; c > 1; c--) {
            room[cleaner[1]][c] = room[cleaner[1]][c - 1];
        }
        room[cleaner[1]][1] = 0;
    }

    // 남아 있는 미세먼지 양 계산
    static int calculateDustAmount() {
        int amount = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (room[r][c] > 0) {
                    amount += room[r][c];
                }
            }
        }
        return amount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        int T = scanner.nextInt(); // 시간

        room = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                room[r][c] = scanner.nextInt();
                if (room[r][c] == -1 && cleaner[0] == 0) {
                    cleaner[0] = r;
                }
            }
        }
        cleaner[1] = cleaner[0] + 1;

        for (int t = 0; t < T; t++) {
            spreadDust();
            operatePurifier();
        }

        int result = calculateDustAmount();
        System.out.println(result);
    }
}
