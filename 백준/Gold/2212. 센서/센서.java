import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 센서의 개수
        int K = scanner.nextInt(); // 집중국의 개수

        int[] sensors = new int[N]; // 센서의 좌표를 저장할 배열

        // 센서의 좌표 입력 받기
        for (int i = 0; i < N; i++) {
            sensors[i] = scanner.nextInt();
        }

        // 센서의 좌표를 오름차순으로 정렬
        Arrays.sort(sensors);

        // 인접한 센서 사이의 거리를 구해서 저장할 배열
        int[] distances = new int[N - 1];

        // 인접한 센서 사이의 거리를 구함
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 센서 사이의 거리를 내림차순으로 정렬
        Arrays.sort(distances);

        // 가장 긴 거리부터 K - 1개의 거리를 제외한 나머지 거리를 더함
        for (int i = 0; i < K - 1 && i < N - 1; i++) {
            distances[N - 2 - i] = 0;
        }

        // 거리의 합을 구함
        int sum = 0;
        for (int distance : distances) {
            sum += distance;
        }

        // 결과 출력
        System.out.println(sum);
    }
}
