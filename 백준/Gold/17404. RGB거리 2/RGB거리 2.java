import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s;

        int[][] rgb = new int[n][3];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                rgb[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[][][] choiceFirst = new int[3][n][3]; // i(첫 색깔), j(n번째 집까지의 최소값), k(rgb)
        choiceFirst[0][0][0] = rgb[0][0];
        choiceFirst[1][0][1] = rgb[0][1];
        choiceFirst[2][0][2] = rgb[0][2];

        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){ // 첫번째 선택한 게 rgb : j.

                // red
                int a = choiceFirst[j][i-1][1];
                int b = choiceFirst[j][i-1][2];

                if(a * b != 0){ // 둘 다 0이 아닐 때
                    choiceFirst[j][i][0] = Math.min(a,b) + rgb[i][0];
                } else if (a != b){ // 1개만 0일 때
                    choiceFirst[j][i][0] = Math.max(a,b) + rgb[i][0];
                }

                // green
                a = choiceFirst[j][i-1][0];
                b = choiceFirst[j][i-1][2];

                if(a * b != 0){
                    choiceFirst[j][i][1] = Math.min(a,b) + rgb[i][1];
                } else if (a != b){
                    choiceFirst[j][i][1] = Math.max(a,b) + rgb[i][1];
                }

                // blue
                a = choiceFirst[j][i-1][0];
                b = choiceFirst[j][i-1][1];

                if(a * b != 0){
                    choiceFirst[j][i][2] = Math.min(a,b) + rgb[i][2];
                } else if (a != b){
                    choiceFirst[j][i][2] = Math.max(a,b) + rgb[i][2];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){ // 첫번째 집 색
            for(int j=0;j<3;j++){ // 마지막 집 색
                if(i==j) continue;
                min = Math.min(min, choiceFirst[i][n-1][j]);
            }
        }
        System.out.println(min);
    }
}